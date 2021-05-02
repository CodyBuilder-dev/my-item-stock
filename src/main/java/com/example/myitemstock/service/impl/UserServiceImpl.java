package com.example.myitemstock.service.impl;

import com.example.myitemstock.entity.Item;
import com.example.myitemstock.entity.User;
import com.example.myitemstock.repository.UserRepository;
import com.example.myitemstock.service.UserService;

import java.util.Set;

public class UserServiceImpl implements UserService {

    private UserRepository userRepository;

    // Service는 오직 구체적인 Java Business Logic만 하도록 설계
    public Set<Item> getUserItems(User user){
        return user.getItems();
    }

}
