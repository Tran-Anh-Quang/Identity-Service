package com.quangta.service.impl;

import java.time.Instant;
import java.util.Date;
import java.util.Random;

import com.quangta.dto.record.ViaMailBody;
import com.quangta.dto.request.ForgotPasswordRequest;
import com.quangta.dto.request.VerifyOTPRequest;
import com.quangta.entity.OtpViaEmail;
import com.quangta.exception.AppException;
import com.quangta.exception.ErrorCode;
import com.quangta.exception.OTPErrorCode;
import com.quangta.exception.OTPException;
import com.quangta.repository.OtpViaEmailRepository;
import com.quangta.repository.UserRepository;
import com.quangta.service.OtpViaEmailService;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = lombok.AccessLevel.PRIVATE, makeFinal = true)
public class OtpViaEmailServiceImpl implements OtpViaEmailService {
    JavaMailSender emailSender;

    UserRepository userRepository;

    OtpViaEmailRepository otpViaEmailRepository;

    Random random = new Random();

    @Override
    public void sendOtpCode(ForgotPasswordRequest request) {
        var user = userRepository
                .findByEmail(request.getEmail())
                .orElseThrow(() -> new AppException(ErrorCode.USER_NOT_EXISTED));

        int otpCode = otpGenerator();
        ViaMailBody mailBody = ViaMailBody.builder()
                .to(request.getEmail())
                .text("This is the OTP for forgot password: " + otpCode)
                .subject("OTP for Forgot Password request")
                .build();

        OtpViaEmail otpViaEmail = OtpViaEmail.builder()
                .otpCode(otpCode)
                .expireTime(new Date(System.currentTimeMillis() + 70 * 1000))
                .user(user)
                .build();

        sendSimpleMessage(mailBody);
        otpViaEmailRepository.save(otpViaEmail);
    }

    @Override
    public void verifyOtpCode(VerifyOTPRequest request) {
        var user = userRepository
                .findByEmail(request.getEmail())
                .orElseThrow(() -> new AppException(ErrorCode.USER_NOT_EXISTED));

        var otpCode = otpViaEmailRepository
                .findByOtpAndUser(request.getOtpCode(), user)
                .orElseThrow(() -> new OTPException(OTPErrorCode.INVALID_OTP));

        if (otpCode.getExpireTime().before(Date.from(Instant.now()))) {
            otpViaEmailRepository.delete(otpCode);
            throw new OTPException(OTPErrorCode.OTP_EXPIRED);
        }

        if (otpCode.getOtpCode().equals(request.getOtpCode())) {
            otpViaEmailRepository.delete(otpCode);
        }
    }

    public void sendSimpleMessage(ViaMailBody mailBody) {
        SimpleMailMessage message = new SimpleMailMessage();

        message.setTo(mailBody.to());
        message.setFrom("noreply@ugts.com");
        message.setSubject(mailBody.subject());
        message.setText(mailBody.text());

        emailSender.send(message);
    }

    public Integer otpGenerator() {
        return random.nextInt(1000, 9999);
    }
}
