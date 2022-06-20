package com.example.springproject_01.controller;

import com.example.springproject_01.entity.InputProduct;
import com.example.springproject_01.payload.InputProductDto;
import com.example.springproject_01.payload.Result;
import com.example.springproject_01.service.InputProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.List;

@RestController
@RequestMapping("/inputproduct")
public class InputProductController {
    @Autowired
    InputProductService inputProductService;

    @PostMapping
    public Result add(@RequestBody InputProductDto dto) throws ParseException {
        return inputProductService.add(dto);
    }

    @GetMapping
    public List<InputProduct> get(){
        return inputProductService.get();
    }

    @DeleteMapping("/delet/{id}")
    public Result delet(@PathVariable Integer id){
        return inputProductService.delet(id);
    }
    @PutMapping("/put/{id}")
    public Result put(@PathVariable Integer id,@RequestBody InputProductDto dto) throws ParseException {
        return inputProductService.put(id, dto);
    }



}
