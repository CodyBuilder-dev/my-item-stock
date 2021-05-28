package com.example.myitemstock.domain.login.service.impl;

import com.example.myitemstock.domain.login.exception.InvalidPasswordException;
import com.example.myitemstock.domain.login.model.LoginModel;
import com.example.myitemstock.entity.User;
import com.example.myitemstock.exception.UserNotFoundException;
import com.example.myitemstock.repository.UserRepository;
import com.example.myitemstock.domain.login.service.LoginService;
import org.springframework.stereotype.Service;

@Service
public class LoginServiceImpl implements LoginService {

    private UserRepository userRepository;

    LoginServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public boolean checkPassword(LoginModel loginModel) {
        User user = userRepository.findByEmail(loginModel.getEmail())
                .orElseThrow(() -> new UserNotFoundException("그런 유저가 존재하지 않습니다"));
        if (user.getPassword().getPassword().equals(loginModel.getPassword())) {
            return true;
        } else {
            throw new InvalidPasswordException("패스워드가 일치하지 않습니다");
        }
    }
}
