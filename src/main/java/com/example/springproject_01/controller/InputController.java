package com.example.springproject_01.controller;

import com.example.springproject_01.entity.Input;
import com.example.springproject_01.payload.InputDto;
import com.example.springproject_01.payload.Result;
import com.example.springproject_01.service.InputService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping("/input")
public class InputController {

    @Autowired
    InputService inputService;

    @PostMapping
    public Result add(@RequestBody InputDto dto){
        return inputService.add(dto);
    }
    @GetMapping
    public List<Input> get(){
        return inputService.get();
    }

    @DeleteMapping("/delet/{id}")
    public Result delet(@PathVariable Integer id){
        return inputService.delet(id);
    }
    @GetMapping("/getId/{id}")
    public Input getId(@PathVariable Integer id){
        return inputService.getId(id);
    }

    @PutMapping("/put/{id}")
    public Result put(@PathVariable Integer id, @RequestBody InputDto dto){
        return inputService.put(id, dto);
    }


}
