package com.example.springproject_01.repository;

import com.example.springproject_01.entity.Output;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OutputRepositroy extends JpaRepository<Output,Integer> {
}
