package com.example.springproject_01.repository;

import com.example.springproject_01.entity.Currency;
import org.springframework.data.jpa.repository.JpaRepository;


public interface CurrencyRepositriy extends JpaRepository<Currency,Integer> {
    boolean existsByName(String name);
}
