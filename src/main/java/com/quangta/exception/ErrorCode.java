package com.quangta.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public enum ErrorCode {
    UNCATEGORIZED_EXCEPTION(9999, "Uncategorized exception"),
    USER_EXISTED(1001, "User has already existed!"),
    INVALID_KEY(1002, "Invalid message key"),
    USERNAME_INVALID(1003, "Username must be at least 3 characters!"),
    PASSWORD_INVALID(1004, "Password must be at least 8 characters!"),
    USER_NOT_EXISTED(1005, "User not exist!"),
    ;
    private int code;
    private String message;
}
