package com.quangta.service;

import com.quangta.dto.record.ViaMailBody;

public interface OtpViaEmailService {
    void sendSimpleMessage(ViaMailBody mailBody);
}
