package com.example.myitemstock.domain.login.exception;

import com.example.myitemstock.config.ErrorCodeConfig;
import com.example.myitemstock.exception.RuntimeExceptionWithStatus;

public class UserAlreadyExistsException extends RuntimeExceptionWithStatus {
    public UserAlreadyExistsException() {
        super(ErrorCodeConfig.USER_ALREADY_EXISTS.getStatus(),
                ErrorCodeConfig.USER_ALREADY_EXISTS.getMessage());
    }
}