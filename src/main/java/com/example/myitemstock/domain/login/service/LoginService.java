package com.example.myitemstock.domain.login.service;

import com.example.myitemstock.domain.login.model.LoginModel;
import com.example.myitemstock.domain.login.model.SignupModel;

public interface LoginService {
    boolean checkPassword(String loginPassword, String userPassword);

    boolean doLogin(LoginModel loginModel);

    boolean doSignUp(SignupModel signupModel);

}
