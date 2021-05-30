package com.example.myitemstock.domain.login.service.impl;

import com.example.myitemstock.domain.login.exception.InvalidPasswordException;
import com.example.myitemstock.domain.login.exception.WrongPasswordException;
import com.example.myitemstock.domain.login.model.LoginModel;
import com.example.myitemstock.domain.login.model.SignupModel;
import com.example.myitemstock.entity.Password;
import com.example.myitemstock.entity.User;
import com.example.myitemstock.exception.UserNotFoundException;
import com.example.myitemstock.repository.PasswordRepository;
import com.example.myitemstock.repository.UserRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;


import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class LoginServiceImplMockTest {

    // Mock 생성 및 주입
//    UserRepository userRepository = mock(UserRepository.class);
    @Mock UserRepository userRepository;

    @InjectMocks LoginServiceImpl loginServiceImpl;

    @Test
    void checkMockCreation() {
        // given : 테스트케이스 정의

        // when : Mock 객체의 동작 정의

        // then
        Assertions.assertNotNull(userRepository);
    }

    @Test
    void checkMockReturn() {
        // given : 테스트케이스 정의
        User user = new User();
        user.setEmail("gogo@kakao.com");

        // when : Mock 객체의 동작 정의
        when(userRepository.findByEmail("gogo@kakao.com")).thenReturn(Optional.of(user));

        // then : 테스트
        Assertions.assertEquals(Optional.of(user),userRepository.findByEmail("gogo@kakao.com"));
    }

    @Test
    void checkMockInjected() {
        // given
        LoginModel loginModel = new LoginModel("gogo@kakao.com", "1234");

        // when
        when(userRepository.findByEmail("gogo@kakao.com")).thenReturn(Optional.empty());

        // then
        Assertions.assertThrows(UserNotFoundException.class,()->loginServiceImpl.doLogin(loginModel));
    }

    @Test
    void doLogin() {
        // given : 테스트케이스 정의
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();

        User user = new User();
        user.setEmail("gogo@kakao.com");
        Password pwd = new Password(bCryptPasswordEncoder.encode("1234"));
        user.setPassword(pwd);
        user.getPassword().setId(1);

        LoginModel correctInfo = new LoginModel("gogo@kakao.com", "1234");
        LoginModel wrongInfo = new LoginModel("gogo@kakao.com", "1235");

        // when : mock 객체의 행동 설정
        when(userRepository.findByEmail("gogo@kakao.com")).thenReturn(Optional.of(user));

        // then : mock을 주입받는 객체의 동작 검증
        Assertions.assertTrue(loginServiceImpl.doLogin(correctInfo));
        Assertions.assertThrows(WrongPasswordException.class,()->loginServiceImpl.doLogin(wrongInfo));
    }

}