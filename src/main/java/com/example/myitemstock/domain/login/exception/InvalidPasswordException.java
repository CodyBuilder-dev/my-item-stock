package com.example.myitemstock.domain.login.exception;

import com.example.myitemstock.config.ErrorCodeConfig;
import com.example.myitemstock.exception.RuntimeExceptionWithStatus;

public class InvalidPasswordException extends RuntimeExceptionWithStatus {

    public InvalidPasswordException() {
        super(ErrorCodeConfig.INVALID_PASSWORD.getStatus(),
                ErrorCodeConfig.INVALID_PASSWORD.getMessage());
    }

}
