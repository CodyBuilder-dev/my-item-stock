package com.example.myitemstock.exception;

import com.example.myitemstock.config.ErrorCodeConfig;

public class UserAlreadyExistsException extends RuntimeExceptionWithStatus {
    public UserAlreadyExistsException() {
        super(ErrorCodeConfig.USER_ALREADY_EXISTS.getStatus(),
                ErrorCodeConfig.USER_ALREADY_EXISTS.getMessage());
    }
}