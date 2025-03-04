package com.devteria.identity_service.exception;

public enum ErrorCode {
    UNCATEGORIZED_EXCEPTION(999, "Unclassified exception"),
    INVALID_KEY(1001, "Invalid message key"),
    USER_EXISTED(1002, "User already exists"),
    USERNAME_INVALID(1003, "Username must be between 3 and 20 characters"),
    PASSWORD_INVALID(1004, "Password must be between 8 and 20 characters"),
    USER_NOT_EXISTED(1005, "User not existed"),
    UNAUTHENTICATED(1006, "Unauthenticated");

    private final Integer code;
    private final String message;

    ErrorCode(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public Integer getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
