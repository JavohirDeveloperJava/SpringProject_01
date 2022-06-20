package com.example.springproject_01.controller;

import com.example.springproject_01.entity.User;
import com.example.springproject_01.payload.Result;
import com.example.springproject_01.payload.UserDto;
import com.example.springproject_01.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;
    @PostMapping
    public Result add(@RequestBody UserDto dto){
        return userService.add(dto);
    }
    @GetMapping
    public List<User> get(){
        return userService.get();
    }

    @DeleteMapping("/delet/{id}")
    public Result delet(@PathVariable Integer id){
        return userService.delet(id);
    }

    @PutMapping("/put/{id}")
    public Result put(@PathVariable Integer id,@RequestBody UserDto dto){
        return userService.put(id, dto);
    }

    @GetMapping("/getId/{id}")
    public User getId(@PathVariable Integer id){
        return userService.hetId(id);
    }

}
