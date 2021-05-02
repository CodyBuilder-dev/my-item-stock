package com.example.myitemstock.service;

import com.example.myitemstock.entity.Item;
import com.example.myitemstock.entity.User;

import java.util.List;
import java.util.Set;

public interface UserService {
    // Service 인터페이스는 오직 명세만 정의하도록
    Set<Item> getUserItems(User user);

    void addUser(User user);

    List<User> getUsers();
}
