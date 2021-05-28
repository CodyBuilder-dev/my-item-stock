package com.example.myitemstock.domain.login.exception;

public class InvalidPasswordException extends RuntimeException{
    public InvalidPasswordException(String msg) {
        super(msg);
    }
}
