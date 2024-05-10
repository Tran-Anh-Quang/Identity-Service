package com.quangta.exception;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public enum OTPErrorCode {
    INVALID_OTP(1001, "Invalid OTP", HttpStatus.BAD_REQUEST),
    OTP_EXPIRED(1002, "OTP has expired", HttpStatus.BAD_REQUEST),
    OTP_NOT_EXISTED(1003, "OTP not existed", HttpStatus.BAD_REQUEST),
    ;
    int code;
    String message;
    HttpStatusCode httpStatusCode;
}
