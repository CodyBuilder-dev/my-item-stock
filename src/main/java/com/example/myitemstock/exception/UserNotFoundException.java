package com.example.myitemstock.exception;

import com.example.myitemstock.config.ErrorCodeConfig;

public class UserNotFoundException extends RuntimeExceptionWithStatus {
    public UserNotFoundException() {
        super(ErrorCodeConfig.USER_NOT_FOUND.getStatus(),
                ErrorCodeConfig.USER_NOT_FOUND.getMessage());
    }
}
