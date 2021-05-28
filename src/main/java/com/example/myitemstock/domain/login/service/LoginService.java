package com.example.myitemstock.domain.login.service;

import com.example.myitemstock.domain.login.model.LoginModel;

public interface LoginService {
    boolean checkPassword(LoginModel loginModel);
}
