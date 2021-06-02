package com.example.myitemstock.entity;

import com.sun.istack.NotNull;

import javax.persistence.*;

@MappedSuperclass
public abstract class CommonCode {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    @Column(nullable = false) String categoryCode;
    public String getCategoryCode() {
        return categoryCode;
    }
    public void setCategoryCode(String categoryCode) {
        this.categoryCode = categoryCode;
    }

    @Column(nullable = false) String categoryName;
    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

}

