package com.example.myitemstock.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
public class Parent {
    @Id @GeneratedValue
    private long id;

    @OneToMany
    private List<Child> children;
}
