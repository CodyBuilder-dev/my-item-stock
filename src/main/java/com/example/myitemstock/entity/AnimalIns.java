package com.example.myitemstock.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
public class AnimalIns {

    @Id
    @Column(name="animal_id")
    private String id;

    public String getId() { return id; }

    public void setId(String id) { this.id = id; }

    @Column(name="name")
    private String name;

    public String getName() { return name; }

    public void setName(String name) { this.name = name; }

    @Column(name="animal_type")
    private String type;

    public String getType() { return type; }

    public void setType(String type) { this.type = type; }
}
