//package com.example.doghotel_springboot_security.controller;
//
//import com.example.doghotel_springboot_security.model.Category;
//import com.example.doghotel_springboot_security.service.CategoryService;
//import lombok.AllArgsConstructor;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//
//import java.util.List;
//
//@Controller
//@AllArgsConstructor
//public class CategoryController {
//    private final CategoryService categoryService;
//
//    @GetMapping("/booking/categories")
//    public String listCategories(Model model){
//        List<Category> listCategories = categoryService.findAll();
//        model.addAttribute("listCategories", listCategories);
//        return "booking/categories";
//    }
//
//}
