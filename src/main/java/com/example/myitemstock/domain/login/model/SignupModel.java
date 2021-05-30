package com.example.myitemstock.domain.login.model;

import com.example.myitemstock.entity.Item;

import java.util.Set;

public class SignupModel {

    public SignupModel(String email, String nickname, String password) {

        this.email = email;
        this.nickname = nickname;
        this.password = password;
    }

    private String email;


    public String getEmail() {
        return email;
    }


    private String nickname;
    public String getNickname() {
        return nickname;
    }


    private String password;
    public String getPassword() { return password; }


}
