package com.example.myitemstock.domain.itemlist.model;

public class ItemListRequest {
    public ItemListRequest() {}
    public ItemListRequest(String email) {
        this.email = email;
    }

    private String email;
    public String getEmail() { return email; }
}
