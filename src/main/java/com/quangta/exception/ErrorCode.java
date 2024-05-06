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
public enum ErrorCode {
    UNCATEGORIZED_EXCEPTION(9999, "Uncategorized exception", HttpStatus.INTERNAL_SERVER_ERROR),
    USER_EXISTED(1001, "User has already existed!", HttpStatus.BAD_REQUEST),
    INVALID_MESSAGE_KEY(1002, "Invalid message key", HttpStatus.BAD_REQUEST),
    USERNAME_INVALID(1003, "Username must be at least {min} characters!", HttpStatus.BAD_REQUEST),
    PASSWORD_INVALID_1(1004, "Password must be at least {min} characters!", HttpStatus.BAD_REQUEST),
    USER_NOT_EXISTED(1005, "User not exist!", HttpStatus.NOT_FOUND),
    UNAUTHENTICATED(1006, "Unauthenticated!", HttpStatus.UNAUTHORIZED),
    UNAUTHORIZED(1007, "Unauthorized!", HttpStatus.FORBIDDEN),
    INVALID_DOB(1008, "Your age must be at least {min}", HttpStatus.BAD_REQUEST),
    PHONE_NUMBER_INVALID(1009, "Your phone number must be {min} number", HttpStatus.BAD_REQUEST),
    EMAIL_INVALID(1010, "Your email is invalid", HttpStatus.BAD_REQUEST),
    PASSWORD_INVALID_2(
            1011,
            "Password must contain at least 1 small letter, capital letter, number and special character",
            HttpStatus.BAD_REQUEST
    ),
    PHONE_NUMBER_EXISTED(1012, "Your phone number has already existed", HttpStatus.BAD_REQUEST),
    EMAIL_EXISTED(1013, "Your email has already existed", HttpStatus.BAD_REQUEST),
    LAST_NAME_INVALID(1014, "Last name must be at least {min} characters", HttpStatus.BAD_REQUEST),
    FIRST_NAME_INVALID(1015, "First name must be at least {min} characters", HttpStatus.BAD_REQUEST),
    ;
    int code;
    String message;
    HttpStatusCode httpStatusCode;
}
