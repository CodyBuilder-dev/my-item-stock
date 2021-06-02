package com.example.myitemstock.domain.statistic.controller;

import com.example.myitemstock.domain.statistic.service.PriceService;
import com.example.myitemstock.domain.statistic.service.impl.PriceServiceImpl;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ItemPriceController {

    private PriceService priceService;

    ItemPriceController(PriceServiceImpl priceService) { this.priceService = priceService;}

    @GetMapping("/api/v1/price")
    public Long getAvgPrice(@RequestBody String name) throws Exception {
        return priceService.getAvgPrice(name);
    }


}
