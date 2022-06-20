package com.example.springproject_01.repository;

import com.example.springproject_01.entity.Measurement;
import org.springframework.data.jpa.repository.JpaRepository;


public interface MeasurementRepository extends JpaRepository<Measurement,Integer> {

    boolean existsByName(String name);

}
