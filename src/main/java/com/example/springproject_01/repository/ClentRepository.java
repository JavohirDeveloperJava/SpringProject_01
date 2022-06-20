package com.example.springproject_01.repository;

import com.example.springproject_01.entity.Clent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClentRepository extends JpaRepository<Clent,Integer> {

    boolean existsByPhoneNumber(String phoneNumber);
}
