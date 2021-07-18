package com.example.myitemstock.domain.login.controller;


import com.example.myitemstock.config.ErrorCodeConfig;
import com.example.myitemstock.domain.login.model.LoginModel;
import com.example.myitemstock.domain.login.model.SignupModel;
import com.example.myitemstock.domain.login.service.LoginService;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.jsonschema.JsonSerializableSchema;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;

@RestController
public class LoginController {

    LoginService loginService;
    @Value("${service-registry.host}")
    private String host;

    @Value("${service-registry.port}")
    private String port;

    @Value("${service-registry.api}")
    private String apiAddress;

    @Value("${service-registry.login.servicename}")
    private String servicename;

    LoginController(LoginService loginService) {
        this.loginService = loginService;
    }

    @PostMapping("/api/user/signup")
    public ResponseEntity signup(@RequestBody SignupModel signupModel) {
        if (loginService.doSignUp(signupModel))
            return new ResponseEntity(HttpStatus.OK);
        else
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
    }

    @PostMapping("/api/v1/user/login")
    @ApiResponses(value = {
            @ApiResponse(code= ErrorCodeConfig.UserNotFound.status,message = ErrorCodeConfig.UserNotFound.message),
            @ApiResponse(code= ErrorCodeConfig.WrongPassword.status,message = ErrorCodeConfig.WrongPassword.message)
    })
    public boolean login(@RequestBody LoginModel loginModel) {
        return loginService.doLogin(loginModel);

    }
    @PostMapping("/api/v2/user/login")
    @ApiResponses(value = {
            @ApiResponse(code= ErrorCodeConfig.UserNotFound.status,message = ErrorCodeConfig.UserNotFound.message),
            @ApiResponse(code= ErrorCodeConfig.WrongPassword.status,message = ErrorCodeConfig.WrongPassword.message)
    })
    public String loginWithMSA(@RequestBody LoginModel loginModel) {
        // 서비스 레지스트리에 로그인 서비스 쿼리
        String loginServiceIp;
        String token;


        try {

            String urlString = "http://" + host + ":" + port + apiAddress +"?name="+servicename;


            URL url = new URL(urlString);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");

            // 반드시 bufferedReader까지 생성해야 정상적으로 통신이 되는듯?왜?
            BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream(), "UTF-8"));

            loginServiceIp = in.readLine();
            connection.disconnect();


            // 받아온 로그인 서비스 주소에 id/pw 던지기
            HashMap<String, String> loginRequest = new HashMap<>();
            loginRequest.put("email", loginModel.getEmail());
            loginRequest.put("password", loginModel.getPassword());
            String loginUrlString = "http://" + loginServiceIp + ":" + "8081" + "/api/user/login";

            String loginJson = new ObjectMapper().writeValueAsString(loginRequest);

            URL loginUrl = new URL(loginUrlString);
            HttpURLConnection loginConnection = (HttpURLConnection) loginUrl.openConnection();
            loginConnection.setRequestMethod("POST");
            loginConnection.setRequestProperty("Content-Type","application/json");

            loginConnection.setDoOutput(true);

            OutputStream outstream = loginConnection.getOutputStream();
            outstream.write(loginJson.getBytes("UTF-8"));
            outstream.flush();

            // 반드시 bufferedReader까지 생성해야 정상적으로 통신이 되는듯?왜?
            BufferedReader instream = new BufferedReader(new InputStreamReader(loginConnection.getInputStream(), "UTF-8"));

            // 토큰을 반환받음
            token = instream.readLine();
            loginConnection.disconnect();
            return token;
        } catch (Exception e) {
            e.printStackTrace();
            return "에러발생";
        }
    }

}
