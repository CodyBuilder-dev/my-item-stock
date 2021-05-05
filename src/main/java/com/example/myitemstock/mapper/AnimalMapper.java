package com.example.myitemstock.mapper;

import org.apache.ibatis.annotations.Mapper;

import java.util.HashMap;
import java.util.List;

@Mapper
public interface AnimalMapper {
    List<HashMap<Object,Object>> selectAllAnimals();
}
