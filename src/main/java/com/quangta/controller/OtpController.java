package com.quangta.controller;

import com.quangta.dto.request.ForgotPasswordRequest;
import com.quangta.dto.request.VerifyOTPRequest;
import com.quangta.dto.response.ApiResponse;
import com.quangta.service.OtpViaEmailService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/forgot-password")
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class OtpController {
    OtpViaEmailService otpViaEmailService;

    @PostMapping()
    public ApiResponse<String> forgotPassword(@RequestBody ForgotPasswordRequest request) {
        otpViaEmailService.sendOtpCode(request);
        return ApiResponse.<String>builder().message("OTP sent successfully").build();
    }

    @PostMapping("/verify-otp")
    public ApiResponse<String> verifyOTP(@RequestBody VerifyOTPRequest request) {
        otpViaEmailService.verifyOtpCode(request);
        return ApiResponse.<String>builder()
                .message("OTP verified successfully")
                .build();
    }
}
