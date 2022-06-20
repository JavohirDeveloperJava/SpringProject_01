package com.example.springproject_01.controller;

import com.example.springproject_01.entity.Category;
import com.example.springproject_01.entity.Product;
import com.example.springproject_01.payload.ProductDto;
import com.example.springproject_01.payload.Result;
import com.example.springproject_01.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    ProductService productService;
    @PostMapping
    public Result addProduct(@RequestBody ProductDto dto){
        return productService.addProd(dto);
    }

    @GetMapping
    public List<Product> get(){
        return productService.get();
    }

    @GetMapping("/get/{id}")
    public Category getpro(@PathVariable Integer id){
        Category getpro = productService.getpro(id);
        return getpro;
    }

    @DeleteMapping("/delet/{id}")
    public Result delet(@PathVariable Integer id){
        return productService.deleted(id);
    }

    @PutMapping("/put/{id}")
    public Result put(@PathVariable Integer id,@RequestBody ProductDto dto){
        return productService.put(id, dto);
    }

}
