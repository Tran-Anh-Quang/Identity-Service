package com.quangta.service;

import com.quangta.dto.request.ForgotPasswordRequest;
import com.quangta.dto.request.VerifyOTPRequest;

public interface OtpViaEmailService {
    void sendOtpCode(ForgotPasswordRequest request);

    void verifyOtpCode(VerifyOTPRequest request);
}
