package com.example.myitemstock.domain.statistic.service;

import java.net.MalformedURLException;

public interface PriceService {
    Long getAvgPrice(String name) throws Exception;
}
