package com.example.myitemstock.domain.login.service.impl;


import com.example.myitemstock.domain.login.model.LoginModel;
import com.example.myitemstock.domain.login.model.SignupModel;
import com.example.myitemstock.domain.login.exception.UserAlreadyExistsException;
import com.example.myitemstock.repository.PasswordRepository;
import com.example.myitemstock.repository.UserRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

@SpringBootTest
@ActiveProfiles("test")
class LoginServiceImplTest {

    @Autowired
    LoginServiceImpl loginServiceImpl;

    @Autowired
    UserRepository userRepository;
    @Autowired
    PasswordRepository passwordRepository;

    @Test
    void doSignUp() {
        // given
        SignupModel signupModel = new SignupModel("gogo@naver.com","navergogo","naver1234");
        LoginModel loginModel = new LoginModel("gogo@naver.com", "naver1234");
        // when


        // then
        // 회원가입 후 로그인 테스트
        Assertions.assertTrue(loginServiceImpl.doSignUp(signupModel));
        Assertions.assertThrows(UserAlreadyExistsException.class,()->loginServiceImpl.doSignUp(signupModel));
        Assertions.assertTrue(loginServiceImpl.doLogin(loginModel));
    }

}