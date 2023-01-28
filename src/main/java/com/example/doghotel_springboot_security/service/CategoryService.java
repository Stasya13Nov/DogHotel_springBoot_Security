package com.example.doghotel_springboot_security.service;

import com.example.doghotel_springboot_security.model.Category;
import com.example.doghotel_springboot_security.repository.CategoryRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CategoryService {
    private  final CategoryRepository categoryRepository;

    public List<Category> findAll() {
       return categoryRepository.findAll();
    }
}
