package com.example.springproject_01.controller;

import com.example.springproject_01.entity.Supplier;
import com.example.springproject_01.payload.Result;
import com.example.springproject_01.payload.SupplierDto;
import com.example.springproject_01.service.SupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping("/supler")
public class SupplierController {
    @Autowired
    SupplierService supplierService;

    @PostMapping
    public Result add(@RequestBody SupplierDto dto){
        return supplierService.add(dto);
    }

    @GetMapping
    public List<Supplier> get(){
        return supplierService.get();
    }

    @DeleteMapping("/delet/{id}")
    public Result delet(@PathVariable Integer id){
        return supplierService.delet(id);
    }

    @PutMapping("/put/{id}")
    public Result put(@PathVariable Integer id, @RequestBody SupplierDto dto){
        return supplierService.put(id, dto);
    }
}
