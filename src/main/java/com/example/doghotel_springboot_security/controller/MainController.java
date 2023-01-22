package com.example.doghotel_springboot_security.controller;

import org.springframework.web.bind.annotation.GetMapping;

public class MainController {
    @GetMapping
    public String getAllInfo(){
        return "index";
    }

    @GetMapping("/403")
    public String error403(){
        return "403";
    }
    @GetMapping("/new")
    public String create(){
        return "new";
    }
    @GetMapping("/delete")
    public String delete(){
        return "delete";
    }
    @GetMapping("/users")
    public String users(){
        return "users";
    }

}
