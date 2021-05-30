package com.example.myitemstock.domain.login.service.impl;

import com.example.myitemstock.domain.login.exception.InvalidPasswordException;
import com.example.myitemstock.domain.login.exception.WrongPasswordException;
import com.example.myitemstock.domain.login.model.LoginModel;
import com.example.myitemstock.domain.login.model.SignupModel;
import com.example.myitemstock.entity.Password;
import com.example.myitemstock.entity.User;
import com.example.myitemstock.exception.UserAlreadyExistsException;
import com.example.myitemstock.exception.UserNotFoundException;
import com.example.myitemstock.repository.PasswordRepository;
import com.example.myitemstock.repository.UserRepository;
import com.example.myitemstock.domain.login.service.LoginService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class LoginServiceImpl implements LoginService {

    private UserRepository userRepository;
    private PasswordRepository passwordRepository;

    LoginServiceImpl(UserRepository userRepository,
                     PasswordRepository passwordRepository) {
        this.userRepository = userRepository;
        this.passwordRepository = passwordRepository;

    }

    @Override
    public boolean checkPassword(String loginPassword, String userPassword) {
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();

        return bCryptPasswordEncoder.matches(loginPassword, userPassword);
    }

    @Override
    public boolean doLogin(LoginModel loginModel) {
        User user = userRepository.findByEmail(loginModel.getEmail())
                .orElseThrow(() -> new UserNotFoundException());
        if(checkPassword(loginModel.getPassword(),user.getPassword().getPassword())){
            return true;
        } else {
            throw new WrongPasswordException();
        }
    }

    @Override
    public boolean doSignUp(SignupModel signupModel) {
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        String encodedPassword = bCryptPasswordEncoder.encode(signupModel.getPassword());
        Password password = new Password(encodedPassword);

        passwordRepository.save(password);

        User user = new User();
        user.setEmail(signupModel.getEmail());
        user.setNickname(signupModel.getNickname());
        user.setPassword(password);

        if (userRepository.findByEmail(signupModel.getEmail()).isPresent()){
            throw new UserAlreadyExistsException();
        }

        return userRepository.save(user) != null;

    }
}
