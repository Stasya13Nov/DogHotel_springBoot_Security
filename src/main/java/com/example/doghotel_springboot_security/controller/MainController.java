package com.example.doghotel_springboot_security.controller;

import org.springframework.web.bind.annotation.GetMapping;

public class MainController {
    @GetMapping
    public String getAllInfo(){
        return "index";
    }
}
