package com.example.springproject_01.repository;

import com.example.springproject_01.entity.InputProduct;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InputProductRepository extends JpaRepository<InputProduct,Integer> {
}
