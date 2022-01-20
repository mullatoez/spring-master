package com.daily_code_coolapp.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomePageController {

    @Value("${home.message}")
    private String home_message;

    @GetMapping("/home")
    public String printHomePage() {
        return home_message;
    }

}
