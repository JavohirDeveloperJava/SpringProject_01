package com.example.springproject_01.service;

import com.example.springproject_01.entity.Input;
import com.example.springproject_01.entity.InputProduct;
import com.example.springproject_01.entity.Measurement;
import com.example.springproject_01.entity.Product;
import com.example.springproject_01.payload.InputProductDto;
import com.example.springproject_01.payload.Result;
import com.example.springproject_01.repository.InputProductRepository;
import com.example.springproject_01.repository.InputRepository;
import com.example.springproject_01.repository.MeasurementRepository;
import com.example.springproject_01.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class InputProductService {
    @Autowired
    InputProductRepository inputProductRepository;
    @Autowired
    InputRepository inputRepository;
    @Autowired
    MeasurementRepository measurementRepository;
    @Autowired
    ProductRepository productRepository;

    public Result add(InputProductDto dto) throws ParseException {
        Optional<Input> optionalInput = inputRepository.findById(dto.getProduct());
        if (!optionalInput.isPresent()){
            return new Result("Bunday Input yoq",false);
        }
        Optional<Product> optionalProduct = productRepository.findById(dto.getProduct());
        if (!optionalProduct.isPresent()){
            return new Result("bunday product yoq",false);
        }
        Date date=new SimpleDateFormat("dd/MM/yyyy").parse(dto.getExpireDate());
        InputProduct inputProduct=new InputProduct();
        inputProduct.setProduct(optionalProduct.get());
        inputProduct.setAmount(dto.getAmount());
        inputProduct.setPrice(dto.getPrice());
        inputProduct.setExpireDate(date);
        inputProduct.setInput(optionalInput.get());
        inputProductRepository.save(inputProduct);
        return new Result("InpuProduct saqlandi",true);
    }

    public List<InputProduct> get(){
        return inputProductRepository.findAll();
    }

    public Result delet(Integer id){
        Optional<InputProduct> optionalInputProduct = inputProductRepository.findById(id);
        if (optionalInputProduct.isPresent()){
            inputProductRepository.deleteById(id);
            return new Result("Input product ochdi",true);
        }
        return new Result("Ochmadi hatolik",false);
    }

    public Result put(Integer id,InputProductDto dto) throws ParseException {
        Optional<Product> optionalProduct = productRepository.findById(dto.getProduct());
        if (!optionalProduct.isPresent()){
            return new Result("bunday product yoq",false);
        }
        Optional<Input> optionalInput = inputRepository.findById(dto.getInputId());
        if (!optionalInput.isPresent()){
            return new Result("Bunday Input yoq",false);
        }
        Date date=new SimpleDateFormat("dd/MM/yyyy").parse(dto.getExpireDate());
        InputProduct inputProduct=new InputProduct();
        inputProduct.setInput(optionalInput.get());
        inputProduct.setProduct(optionalProduct.get());
        inputProduct.setPrice(dto.getPrice());
        inputProduct.setAmount(dto.getAmount());
        inputProduct.setExpireDate(date);
        inputProductRepository.save(inputProduct);
        return new Result("Input product ozgardi",true);
    }



}
