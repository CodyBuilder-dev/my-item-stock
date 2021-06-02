package com.example.myitemstock.domain.itemlist.controller;

import com.example.myitemstock.domain.itemlist.model.ItemListRequest;
import com.example.myitemstock.domain.itemlist.model.ItemListResponse;
import com.example.myitemstock.entity.Item;
import com.example.myitemstock.entity.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ItemListController {
    @GetMapping("/api/user/item")
    public ResponseEntity getItemList(@RequestBody ItemListRequest itemListRequest){
        Item item1 = Item.builder()
                .name("Item1")
                .amount(2L)
                .build();
        Item item2 = Item.builder()
                .name("Item2")
                .amount(4L)
                .build();

        Item item3 = Item.builder()
                .name("Item3")
                .amount(6L)
                .build();

        Item item4 = Item.builder()
                .name("Item4")
                .amount(10L)
                .build();

        ItemListResponse itemListResponse = new ItemListResponse();
        itemListResponse.getItemList().add(item1);
        itemListResponse.getItemList().add(item2);
        itemListResponse.getItemList().add(item3);
        itemListResponse.getItemList().add(item4);

        return new ResponseEntity(itemListResponse, HttpStatus.OK);

    }

    /**
     * 요구 : 정보를 받아 특정 유저에 아이템을 등록해주세요
     * 조건 : 만약 해당 유저가 없는 경우 실패를 반환해주세요
     */
    @PostMapping("/api/user/item")
    public Item addItem(@RequestBody User user, @RequestBody Item item){
        return null;
    }




}
