package com.example.myitemstock.domain.statistic.controller;

import com.example.myitemstock.domain.itemlist.model.ItemListRequest;
import com.example.myitemstock.domain.itemlist.model.ItemListResponse;
import com.example.myitemstock.entity.Item;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

public class ItemStatisticController {
    @GetMapping("/api/user/item/statistic")
    public ResponseEntity getItemStatistic(@RequestBody ItemListRequest itemListRequest) {
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
}
