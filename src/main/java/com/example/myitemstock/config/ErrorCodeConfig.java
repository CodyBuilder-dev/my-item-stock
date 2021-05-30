package com.example.myitemstock.config;

public enum ErrorCodeConfig {
    USER_NOT_FOUND(UserNotFound.status,UserNotFound.message),
    WRONG_PASSWORD(WrongPassword.status,WrongPassword.message),
    INVALID_PASSWORD(400,"패스워드 형식이 맞지 않습니다"),
    USER_ALREADY_EXISTS(UserAlreadyExists.status, UserAlreadyExists.message)
    ;


    private int status;
    private String message;

    public int getStatus() {
        return status;
    }

    public String getMessage() {
        return message;
    }


    ErrorCodeConfig(int status, String message) {
        this.status = status;
        this.message = message;
    }

    // enum을 static하게 바꿔 Annotation에서 사용가능
    public static class UserNotFound {
        public static final int status = 405;
        public static final String message = "그런 유저가 존재하지 않습니다";
    }
    public static class WrongPassword {
        public static final int status = 406;
        public static final String message = "패스워드가 일치하지 않습니다";
    }

    public static class UserAlreadyExists {
        public static final int status = 407;
        public static final String message = "이미 가입된 회원입니다";
    }
}
