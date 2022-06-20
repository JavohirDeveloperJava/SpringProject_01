package com.example.springproject_01.service;

import com.example.springproject_01.entity.Attechment;
import com.example.springproject_01.entity.Category;
import com.example.springproject_01.entity.Measurement;
import com.example.springproject_01.entity.Product;
import com.example.springproject_01.payload.ProductDto;
import com.example.springproject_01.payload.Result;
import com.example.springproject_01.repository.AttechmentRepository;
import com.example.springproject_01.repository.CategoryRepositroy;
import com.example.springproject_01.repository.MeasurementRepository;
import com.example.springproject_01.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    ProductRepository productRepository;
    @Autowired
    CategoryRepositroy categoryRepositroy;
    @Autowired
    AttechmentRepository attechmentRepository;
    @Autowired
    MeasurementRepository measurementRepository;


    public Result addProd(ProductDto dto){
        boolean exists = productRepository.existsByNameAndCategoryId(dto.getName(), dto.getCategoryId());
        if (exists){
            return new Result("Bunday mahsulot ushbu category da mavjud ",false);
        }
        Optional<Category> optionalCategory = categoryRepositroy.findById(dto.getCategoryId());
        if (!optionalCategory.isPresent()){
            return new Result("Bunday category mavjut emas",false);
        }


        Optional<Attechment> optionalAttechment = attechmentRepository.findById(dto.getPhotoId());
        if (!optionalAttechment.isPresent()){
            return new Result("Bunday rasim mavjut emas",false);
        }

        Optional<Measurement> optionalMeasurement = measurementRepository.findById(dto.getMeasurementId());
        if (!optionalMeasurement.isPresent()){
            return new Result("Bunday measurement mavjut emas",false);
        }


        Product product=new Product();
        product.setName(dto.getName());
        product.setCode("1");
        product.setCategory(optionalCategory.get());
        product.setMeasurement(optionalMeasurement.get());
        product.setPhoto(optionalAttechment.get());
        productRepository.save(product);
        return new Result("Mahsulot saqlandi",true);


    }
//    public String coded(Product product){
//        Integer id = product.getId()+1;
//        return id.toString();
//    }

    public List<Product> get(){
        return productRepository.findAll();
    }

    public Category getpro(Integer id){
        Optional<Category> optionalCategory = categoryRepositroy.findById(id);
        if (optionalCategory.isPresent()){
            Category category = optionalCategory.get();
            return category;
        }
        return new Category();
    }

    public Result deleted(Integer id){
        Optional<Product> optionalProduct = productRepository.findById(id);
        if (optionalProduct.isPresent()){
            productRepository.deleteById(id);
            return new Result("Product ochdi",true);
        }
        return new Result("Hatolik ochmadi",false);
    }

    public Result put(Integer id,ProductDto dto){
        Optional<Product> optionalProduct = productRepository.findById(id);
        if (!optionalProduct.isPresent()){
            return new Result("Bunday product yoq",false);
        }
        Optional<Attechment> optionalAttechmentt = attechmentRepository.findById(dto.getPhotoId());
        if (!optionalAttechmentt.isPresent()){
            return new Result("Bunday rasim mavjut emas",false);
        }
        Optional<Measurement> optionalMeasurement = measurementRepository.findById(dto.getMeasurementId());
        if (!optionalMeasurement.isPresent()){
            return new Result("Bunday measurement mavjut emas",false);
        }
        Optional<Category> optionalCategory = categoryRepositroy.findById(dto.getCategoryId());
        if (!optionalCategory.isPresent()){
            return new Result("Bunday category mavjut emas",false);
        }


        Product product = optionalProduct.get();
        product.setName(dto.getName());
        product.setCode("2");
        product.setMeasurement(optionalMeasurement.get());
        product.setCategory(optionalCategory.get());
        product.setPhoto(optionalAttechmentt.get());
        productRepository.save(product);
        return new Result("Product ozgardi",true);
    }

}
