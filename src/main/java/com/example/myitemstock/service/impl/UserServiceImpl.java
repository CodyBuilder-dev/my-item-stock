package com.example.myitemstock.service.impl;

import com.example.myitemstock.entity.Item;
import com.example.myitemstock.entity.User;
import com.example.myitemstock.repository.UserRepository;
import com.example.myitemstock.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class UserServiceImpl implements UserService {
    // Service는 오직 구체적인 Java Business Logic만 하도록 설계

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<User> getUsers() {
        return userRepository.findAll();
    }

    @Override
    public Set<Item> getUserItems(User user){
        return user.getItems();
    }

    @Override
    public void addUser(User user) {
        userRepository.save(user);
    }


}
