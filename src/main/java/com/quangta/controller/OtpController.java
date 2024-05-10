package com.quangta.controller;

import com.quangta.dto.record.ViaMailBody;
import com.quangta.dto.request.ForgotPasswordRequest;
import com.quangta.dto.request.VerifyOTPRequest;
import com.quangta.dto.response.ApiResponse;
import com.quangta.entity.OtpViaEmail;
import com.quangta.exception.AppException;
import com.quangta.exception.ErrorCode;
import com.quangta.exception.OTPErrorCode;
import com.quangta.exception.OTPException;
import com.quangta.repository.OtpViaEmailRepository;
import com.quangta.repository.UserRepository;
import com.quangta.service.OtpViaEmailService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.web.bind.annotation.*;

import java.time.Instant;
import java.util.Date;
import java.util.Random;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/forgot-password")
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class OtpController {
    OtpViaEmailService otpViaEmailService;

    UserRepository userRepository;

    OtpViaEmailRepository otpViaEmailRepository;

    @PostMapping()
    public ApiResponse<String> forgotPassword(@RequestBody ForgotPasswordRequest request) {
        var user = userRepository.findByEmail(request.getEmail())
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

        otpViaEmailService.sendSimpleMessage(mailBody);
        otpViaEmailRepository.save(otpViaEmail);

        return ApiResponse.<String>builder()
                .message("OTP sent successfully")
                .build();
    }

    private Integer otpGenerator(){
        Random random = new Random();
        return random.nextInt(1000,9999);
    }

    @PostMapping("/verify-otp")
    public ApiResponse<String> verifyOTP(@RequestBody VerifyOTPRequest request) {
        var user = userRepository.findByEmail(request.getEmail())
                .orElseThrow(() -> new AppException(ErrorCode.USER_NOT_EXISTED));

        var otpCode = otpViaEmailRepository.findByOtpAndUser(request.getOtpCode(), user)
                .orElseThrow(() -> new OTPException(OTPErrorCode.INVALID_OTP));

        if (otpCode.getExpireTime().before(Date.from(Instant.now()))) {
            otpViaEmailRepository.delete(otpCode);
            throw new OTPException(OTPErrorCode.OTP_EXPIRED);
        }

        if (otpCode.getOtpCode().equals(request.getOtpCode())) {
            otpViaEmailRepository.delete(otpCode);
        }
        return ApiResponse.<String>builder()
                .message("OTP verified successfully")
                .build();
    }
}
