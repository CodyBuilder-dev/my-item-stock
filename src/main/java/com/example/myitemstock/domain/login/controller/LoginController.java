package com.example.myitemstock.domain.login.controller;


import com.example.myitemstock.domain.login.model.LoginModel;
import com.example.myitemstock.domain.login.service.LoginService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {

    LoginService loginService;

    LoginController(LoginService loginService) {
        this.loginService = loginService;
    }

    @PostMapping("/api/user/login")
    public boolean login(@RequestBody LoginModel loginModel) {
        return loginService.checkPassword(loginModel);
    }

}
