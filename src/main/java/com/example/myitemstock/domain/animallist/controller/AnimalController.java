package com.example.myitemstock.domain.animallist.controller;

import com.example.myitemstock.domain.animallist.service.AnimalService;
import com.example.myitemstock.domain.animallist.service.impl.AnimalServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.HashMap;
import java.util.List;

@Controller
public class AnimalController {

    private AnimalService animalService;
    public AnimalController(AnimalServiceImpl animalService) {
        this.animalService = animalService;
    }

    /**
     * 요구사항 : 전체 동물의 목록을 받아서 반환하세요
     */
    @GetMapping("/api/v1/animals")
    public String getAllAnimals(Model model){
        List<HashMap<Object,Object>> animalList = animalService.getAllAnimals();
        model.addAttribute("animalList",animalList);
        return "animal-test";
    }
}
