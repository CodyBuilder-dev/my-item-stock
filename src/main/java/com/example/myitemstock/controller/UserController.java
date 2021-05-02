package com.example.myitemstock.controller;

import com.example.myitemstock.entity.Item;
import com.example.myitemstock.entity.User;
import com.example.myitemstock.service.UserService;
import com.example.myitemstock.service.impl.UserServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Set;

@Controller
public class UserController {

    // 의존성을 어떻게 주입할지 고민좀 해봐야 함
    private UserService userService = new UserServiceImpl();


    /**
     * 요구 : 특정 유저의 모든 아이템을 가져와서 보여주세요
     */
    // Controller는 오직 Req,Res만 처리하도록 설계
    @GetMapping("/api/v1/user/items")
    public String getUserItems(Model model, @RequestBody User user){
        Set<Item> items = userService.getUserItems(user);
        model.addAttribute("items", items);

        return "useritems";
    }
}
