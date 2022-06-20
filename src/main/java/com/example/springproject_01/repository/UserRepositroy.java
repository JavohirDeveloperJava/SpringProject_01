package com.example.springproject_01.repository;

import com.example.springproject_01.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UserRepositroy extends JpaRepository<User,Integer> {

    boolean existsByPhoneNumber(String phoneNumber);

    boolean existsByCode(String code);
}
