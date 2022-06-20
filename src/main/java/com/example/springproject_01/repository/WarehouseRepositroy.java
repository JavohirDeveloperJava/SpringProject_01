package com.example.springproject_01.repository;

import com.example.springproject_01.entity.Warehouse;
import org.springframework.data.jpa.repository.JpaRepository;


public interface WarehouseRepositroy extends JpaRepository<Warehouse,Integer> {
    boolean existsByName(String name);
}
