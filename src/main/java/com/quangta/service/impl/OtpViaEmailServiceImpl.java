package com.quangta.service.impl;


import com.quangta.dto.record.ViaMailBody;
import com.quangta.repository.OtpViaEmailRepository;
import com.quangta.repository.UserRepository;
import com.quangta.service.OtpViaEmailService;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = lombok.AccessLevel.PRIVATE, makeFinal = true)
public class OtpViaEmailServiceImpl implements OtpViaEmailService {
    JavaMailSender emailSender;

    UserRepository userRepository;

    OtpViaEmailRepository otpViaEmailRepository;

    Random random = new Random();

    public void sendSimpleMessage(ViaMailBody mailBody){
        SimpleMailMessage message = new SimpleMailMessage();

        message.setTo(mailBody.to());
        message.setFrom("noreply@ugts.com");
        message.setSubject(mailBody.subject());
        message.setText(mailBody.text());

        emailSender.send(message);
    }

}