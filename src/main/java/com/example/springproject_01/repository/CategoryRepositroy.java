package com.example.springproject_01.repository;

import com.example.springproject_01.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;


public interface CategoryRepositroy extends JpaRepository<Category,Integer> {
}
