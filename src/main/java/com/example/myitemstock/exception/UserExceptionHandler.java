package com.example.myitemstock.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class UserExceptionHandler {
    @ExceptionHandler
    public ResponseEntity userNotFoundException(UserNotFoundException e){
        return new ResponseEntity(e.getMessage(), HttpStatus.valueOf(e.getStatus()));
    }
}
