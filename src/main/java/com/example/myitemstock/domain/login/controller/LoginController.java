package com.example.myitemstock.domain.login.controller;


import com.example.myitemstock.config.ErrorCodeConfig;
import com.example.myitemstock.domain.login.model.LoginModel;
import com.example.myitemstock.domain.login.service.LoginService;
import com.fasterxml.jackson.databind.jsonschema.JsonSerializableSchema;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
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
    @ApiResponses(value = {
            @ApiResponse(code= ErrorCodeConfig.UserNotFound.status,message = ErrorCodeConfig.UserNotFound.message),
            @ApiResponse(code= ErrorCodeConfig.WrongPassword.status,message = ErrorCodeConfig.WrongPassword.message)
    })
    public boolean login(@RequestBody LoginModel loginModel) {
        return loginService.checkPassword(loginModel);
    }

}
