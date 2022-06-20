package com.example.springproject_01.controller;

import com.example.springproject_01.entity.Category;
import com.example.springproject_01.payload.CategoryDto;
import com.example.springproject_01.payload.Result;
import com.example.springproject_01.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/category")
public class CategoryController {

    @Autowired
    CategoryService categoryService;


    @PostMapping
    public Result addCategory(@RequestBody CategoryDto categoryDto){
        return categoryService.addCategory(categoryDto);
    }

    @GetMapping
    public List<Category> categories(){
        return categoryService.gett();
    }

    @DeleteMapping("/delet/{id}")
    public Result delet(@PathVariable Integer id){
        return categoryService.delete(id);
    }

    @PutMapping("/put/{id}")
    public Result put(@PathVariable Integer id, @RequestBody CategoryDto dto){
        return categoryService.put(id, dto);
    }
}
