package com.example.myitemstock.controller;

import com.example.myitemstock.entity.Item;
import com.example.myitemstock.entity.User;
import com.example.myitemstock.exception.UserNotFoundException;
import com.example.myitemstock.repository.ItemRepository;
import com.example.myitemstock.repository.UserRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
public class ItemController {

    private final UserRepository userRepository;
    private final ItemRepository itemRepository;

    public ItemController(UserRepository userRepository, ItemRepository itemRepository) {
        this.userRepository = userRepository;
        this.itemRepository = itemRepository;
    }

    /**
     * 요구 : 정보를 받아 특정 유저에 아이템을 등록해주세요
     * 조건 : 만약 해당 유저가 없는 경우 실패를 반환해주세요
     */
    @PostMapping("/api/v1/user/item")
    public Item addItem(@RequestBody User user,@RequestBody Item item){
        User existingUser = userRepository.findById(user.getId())
                                .orElseThrow(()->new UserNotFoundException("해당 유저가 없습니다"));
        return item;
    }

}
