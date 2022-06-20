package com.example.springproject_01.controller;

import com.example.springproject_01.entity.Output;
import com.example.springproject_01.payload.OutputDto;
import com.example.springproject_01.payload.Result;
import com.example.springproject_01.service.OutputService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/output")
public class OutputController {
    @Autowired
    OutputService outputService;

    @PostMapping
    public Result add(@RequestBody OutputDto dto){
        return outputService.add(dto);
    }

    @GetMapping
    public List<Output> get(){
        return outputService.get();
    }

    @DeleteMapping("/delet/{id}")
    public Result delet(@PathVariable Integer id){
        return outputService.delete(id);
    }

    @PutMapping("/put/{id}")
    public Result put(@PathVariable Integer id,@RequestBody OutputDto dto){
        return outputService.put(id, dto);
    }
}
