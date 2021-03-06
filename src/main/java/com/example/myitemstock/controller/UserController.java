package com.example.myitemstock.controller;

import com.example.myitemstock.entity.Item;
import com.example.myitemstock.entity.User;
import com.example.myitemstock.service.UserService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Set;

@RestController
public class UserController {
    // Controller는 오직 Req,Res만 처리하도록 설계
    // 의존성을 어떻게 주입할지 고민좀 해봐야 함

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    /**
     * 요구 : 현재 모든 유저의 정보를 가져와 주세요
     */
    @ApiOperation(value="모든 유저 조회")
    @GetMapping("/api/v1/users")
    public List<User> getUsers() {
        return userService.getUsers();
    }

    /**
     * 요구 : 특정 유저의 모든 아이템을 가져와서 보여주세요
     */
    @ApiOperation(value="유저 아이템 조회")
    @GetMapping("/api/v1/user/items")
    public Set<Item> getUserItems(@ApiParam(value="유저") @RequestBody User user){
        return  userService.getUserItems(user);
    }

    /**
     * 요구 : 정보를 받아 유저를 등록해주세요
     */
    @ApiOperation(value = "유저 등록")
    @PostMapping("/api/v1/user")
    public User addUser(@ApiParam(value="유저") @RequestBody User user) {
        userService.addUser(user);
        return user;
    }
}
