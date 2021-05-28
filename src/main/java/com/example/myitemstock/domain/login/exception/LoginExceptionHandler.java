package com.example.myitemstock.domain.login.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class LoginExceptionHandler {

    @ExceptionHandler(InvalidPasswordException.class)
    public ResponseEntity invalidPasswordException(InvalidPasswordException e) {
        return new ResponseEntity(e.getMessage(), HttpStatus.valueOf(e.getStatus()));
    }

    @ExceptionHandler(WrongPasswordException.class)
    public ResponseEntity wrongPasswordException(WrongPasswordException e) {
        return new ResponseEntity(e.getMessage(), HttpStatus.valueOf(e.getStatus()));
    }
}
