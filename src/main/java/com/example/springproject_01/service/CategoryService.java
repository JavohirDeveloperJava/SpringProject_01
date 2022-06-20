package com.example.springproject_01.service;

import com.example.springproject_01.entity.Category;
import com.example.springproject_01.payload.CategoryDto;
import com.example.springproject_01.payload.Result;
import com.example.springproject_01.repository.CategoryRepositroy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {

    @Autowired
    CategoryRepositroy categoryRepositroy;

    public Result addCategory(CategoryDto categoryDto){
        Category category=new Category();
        category.setName(categoryDto.getName());
        if (categoryDto.getParentCategoryId()!=null){
            Optional<Category> optionalCategory = categoryRepositroy.findById(categoryDto.getParentCategoryId());
            if (!optionalCategory.isPresent()){
                return new Result("Bunday ota category mavjut emas",false);
            }
            category.setParentCategory(optionalCategory.get());
        }
        categoryRepositroy.save(category);
        return new Result("Muofaqiyatlik saqlandi",true);

    }

    public List<Category> gett(){
        List<Category> all = categoryRepositroy.findAll();
        return all;
    }

    public Result delete(Integer id){
        Optional<Category> optionalCategory = categoryRepositroy.findById(id);
        if (optionalCategory.isPresent()){
            categoryRepositroy.deleteById(id);
            return new Result("Ochdi",true);
        }
        return new Result("hatolik ",false);
    }

    public Result put(Integer id, CategoryDto dto){
        Optional<Category> optionalCategory = categoryRepositroy.findById(id);
        if (!optionalCategory.isPresent()){
            return new Result("Bunday idlik category mavjud emas",false);
        }
        Category category = optionalCategory.get();
        category.setName(dto.getName());
        Optional<Category> optionalCategory1 = categoryRepositroy.findById(dto.getParentCategoryId());
        if (!optionalCategory1.isPresent()){
            return new Result("bunday ota idi yoq",false);
        }
        category.setParentCategory(optionalCategory1.get());
        categoryRepositroy.save(category);
        return new Result("Ozgardi",true);
    }
}
