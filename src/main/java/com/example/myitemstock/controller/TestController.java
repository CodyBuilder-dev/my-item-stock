package com.example.myitemstock.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TestController {
    /**
     * 요구 : 테스트 페이지로 이동하는 간단한 컨트롤러를 만드세요
     */
    @GetMapping("/api/v1/test")
    public String goTestPage() {
        return "test";
    }

}
