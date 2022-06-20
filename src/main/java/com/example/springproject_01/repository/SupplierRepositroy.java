package com.example.springproject_01.repository;

import com.example.springproject_01.entity.Supplier;
import org.springframework.data.jpa.repository.JpaRepository;


public interface SupplierRepositroy extends JpaRepository<Supplier,Integer> {
    boolean existsByPhoneNumber(String phoneNumber);
}
