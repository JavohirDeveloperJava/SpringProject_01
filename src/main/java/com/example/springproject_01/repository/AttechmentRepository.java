package com.example.springproject_01.repository;

import com.example.springproject_01.entity.Attechment;
import org.springframework.data.jpa.repository.JpaRepository;


public interface AttechmentRepository extends JpaRepository<Attechment,Integer> {
}
