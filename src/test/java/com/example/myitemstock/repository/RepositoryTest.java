package com.example.myitemstock.repository;

import com.example.myitemstock.entity.Password;
import com.example.myitemstock.entity.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.jdbc.AutoConfigureDataJdbc;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureJdbc;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.AutoConfigureDataJpa;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
@ActiveProfiles("test")
class RepositoryTest {
    @Autowired UserRepository userRepository;
    @Autowired PasswordRepository passwordRepository;

    @Test
    void save() {
        // given
        User user = new User();
        Password password = new Password("test1234");

        user.setEmail("repotest@test.com");
        user.setNickname("Repo Test Nickname");
        user.setPassword(password);

        // when
        Password savedPassword = passwordRepository.save(password);
        User savedUser = userRepository.save(user);

        // then
        Assertions.assertEquals(savedUser,userRepository.findByEmail("repotest@test.com").get());
    }

}