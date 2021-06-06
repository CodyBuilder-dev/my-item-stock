package com.example.myitemstock.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

@Entity
public class MiddleCommonCode extends CommonCode{

    public MiddleCommonCode() {
        this.minorCommonCodeList = new ArrayList<>();
    }

    @OneToMany(cascade = CascadeType.REMOVE, orphanRemoval = true)
    @JoinColumn(name="MIDDLE_ID",nullable = false)
    List<MinorCommonCode> minorCommonCodeList;

    public List<MinorCommonCode> getMinorCommonCodeList() {
        return minorCommonCodeList;
    }
}
