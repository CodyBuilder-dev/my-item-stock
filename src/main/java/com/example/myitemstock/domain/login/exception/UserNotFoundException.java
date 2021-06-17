package com.example.myitemstock.domain.login.exception;

import com.example.myitemstock.config.ErrorCodeConfig;
import com.example.myitemstock.exception.RuntimeExceptionWithStatus;

public class UserNotFoundException extends RuntimeExceptionWithStatus {
    public UserNotFoundException() {
        super(ErrorCodeConfig.USER_NOT_FOUND.getStatus(),
                ErrorCodeConfig.USER_NOT_FOUND.getMessage());
    }
}
