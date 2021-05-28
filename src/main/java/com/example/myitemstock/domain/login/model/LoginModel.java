package com.example.myitemstock.domain.login.model;

public class LoginModel {
    public LoginModel(String email, String password) {
        this.email = email;
        this.password = password;
    }

    private String email;
    public String getEmail() { return email; }

    private String password;
    public String getPassword() { return password; }
}
