package com.example.doghotel_springboot_security.repository;

import com.example.doghotel_springboot_security.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Integer> {
}
