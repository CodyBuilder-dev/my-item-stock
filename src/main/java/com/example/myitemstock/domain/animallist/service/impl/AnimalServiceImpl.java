package com.example.myitemstock.domain.animallist.service.impl;

import com.example.myitemstock.mapper.AnimalMapper;
import com.example.myitemstock.domain.animallist.service.AnimalService;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

@Service
public class AnimalServiceImpl implements AnimalService {

    AnimalMapper animalMapper;
    public AnimalServiceImpl(AnimalMapper animalMapper) {
        this.animalMapper = animalMapper;
    }

    @Override
    public List<HashMap<Object, Object>> getAllAnimals() {
        return animalMapper.selectAllAnimals();
    }

}
