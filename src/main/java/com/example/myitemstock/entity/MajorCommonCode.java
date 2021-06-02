package com.example.myitemstock.entity;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

@Entity
public class MajorCommonCode extends CommonCode {

    public MajorCommonCode(){
        this.middleCommonCodeList = new ArrayList<>();
    }

    @OneToMany
    @JoinColumn(name="MAJOR_ID",nullable = false)
    List<MiddleCommonCode> middleCommonCodeList;

    public List<MiddleCommonCode> getMiddleCommonCodeList() {
        return middleCommonCodeList;
    }
}
