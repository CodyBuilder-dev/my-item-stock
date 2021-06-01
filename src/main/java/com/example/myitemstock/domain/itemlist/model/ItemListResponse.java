package com.example.myitemstock.domain.itemlist.model;

import com.example.myitemstock.entity.Item;

import java.util.ArrayList;
import java.util.List;

public class ItemListResponse {
    public ItemListResponse() {
        this.itemList = new ArrayList<>();
    }
    List<Item> itemList;
    public List<Item> getItemList() {
        return itemList;
    }
}
