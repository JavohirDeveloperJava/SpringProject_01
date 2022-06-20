package com.example.springproject_01.repository;

import com.example.springproject_01.entity.Input;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InputRepository extends JpaRepository<Input,Integer> {
}
