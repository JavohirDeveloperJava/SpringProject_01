package com.example.springproject_01.controller;

import com.example.springproject_01.entity.Clent;
import com.example.springproject_01.payload.ClentDto;
import com.example.springproject_01.payload.Result;
import com.example.springproject_01.service.ClentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping("/clentt")
public class ClentController {
    @Autowired
    ClentService clentService;

    @PostMapping
    public Result add(@RequestBody ClentDto dto){
        return clentService.addd(dto);
    }

    @GetMapping
    public List<Clent> get(){
        return clentService.get();
    }

    @GetMapping("/getId/{id}")
    public Clent getId(@PathVariable Integer id){
        return clentService.getId(id);
    }

    @DeleteMapping("/delet/{id}")
    public Result delet(@PathVariable Integer id){
        return clentService.delet(id);
    }

    @PutMapping("/put/{id}")
    public Result put(@PathVariable Integer id,@RequestBody ClentDto dto){
        return clentService.put(id, dto);
    }
}
