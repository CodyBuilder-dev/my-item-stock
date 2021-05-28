package com.example.myitemstock.exception;

public class RuntimeExceptionWithStatus extends RuntimeException{


    int status;

    public int getStatus() {
        return status;
    }

    public RuntimeExceptionWithStatus(int status, String msg) {
        super(msg);
        this.status = status;
    }

}
