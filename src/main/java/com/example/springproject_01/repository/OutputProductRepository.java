package com.example.springproject_01.repository;

import com.example.springproject_01.entity.OutputProduct;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OutputProductRepository extends JpaRepository<OutputProduct,Integer> {
}
