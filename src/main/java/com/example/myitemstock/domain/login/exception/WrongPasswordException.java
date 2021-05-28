package com.example.myitemstock.domain.login.exception;

import com.example.myitemstock.config.ErrorCodeConfig;
import com.example.myitemstock.exception.RuntimeExceptionWithStatus;

public class WrongPasswordException extends RuntimeExceptionWithStatus {

    public WrongPasswordException() {
        super(ErrorCodeConfig.WRONG_PASSWORD.getStatus(),
                ErrorCodeConfig.WRONG_PASSWORD.getMessage());
    }
}
