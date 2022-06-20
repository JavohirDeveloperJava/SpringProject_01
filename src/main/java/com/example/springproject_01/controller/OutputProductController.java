package com.example.springproject_01.controller;

import com.example.springproject_01.entity.Output;
import com.example.springproject_01.entity.OutputProduct;
import com.example.springproject_01.payload.OutputDto;
import com.example.springproject_01.payload.OutputProductDto;
import com.example.springproject_01.payload.Result;
import com.example.springproject_01.service.OutputProductService;
import com.example.springproject_01.service.OutputService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/outputProduct")
public class OutputProductController {
    @Autowired
    OutputProductService outputProductService;

    @PostMapping
    public Result add(@RequestBody OutputProductDto dto){
        return outputProductService.add(dto);
    }
    @GetMapping
    public List<OutputProduct> get(){
        return outputProductService.get();
    }

    @DeleteMapping("/delet/{id}")
    public Result delet(@PathVariable Integer id){
        return outputProductService.delet(id);
    }
    @GetMapping("/getId/{id}")
    public OutputProduct getId(@PathVariable Integer id){
        return outputProductService.getId(id);
    }

    @PutMapping("/put/{id}")
    public Result put(@PathVariable Integer id,@RequestBody OutputProductDto dto){
        return outputProductService.put(id, dto);
    }

}
