package com.example.springproject_01.service;

import com.example.springproject_01.entity.Output;
import com.example.springproject_01.entity.OutputProduct;
import com.example.springproject_01.entity.Product;
import com.example.springproject_01.payload.OutputProductDto;
import com.example.springproject_01.payload.Result;
import com.example.springproject_01.repository.OutputProductRepository;
import com.example.springproject_01.repository.OutputRepositroy;
import com.example.springproject_01.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OutputProductService {
    @Autowired
    OutputProductRepository outputProductRepository;
    @Autowired
    ProductRepository productRepository;
    @Autowired
    OutputRepositroy outputRepositroy;

    public Result add(OutputProductDto dto){
        Optional<Product> optionalProduct = productRepository.findById(dto.getProductId());
        if (!optionalProduct.isPresent()){
            return new Result("Bunday product mavjut emas",false);
        }
        Optional<Output> optionalOutput = outputRepositroy.findById(dto.getOutputId());
        if (!optionalProduct.isPresent()){
            return new Result("Bunday output mavjut emas",false);
        }

        OutputProduct outputProduct=new OutputProduct();
        outputProduct.setOutput(optionalOutput.get());
        outputProduct.setProduct(optionalProduct.get());
        outputProduct.setAmount(dto.getAmount());
        outputProduct.setPrice(dto.getPrice());
        outputProductRepository.save(outputProduct);
        return new Result("Output produc saqlandi",true);

    }

    public List<OutputProduct> get(){
        return outputProductRepository.findAll();
    }

    public Result delet(Integer id){
        Optional<OutputProduct> outputProductRepositoryById = outputProductRepository.findById(id);
        if (outputProductRepositoryById.isPresent()){
            outputProductRepository.deleteById(id);
            return new Result("Output ochdi",true);
        }
        return new Result("Output hatolik",false);
    }
    public OutputProduct getId(Integer id){
        Optional<OutputProduct> byId = outputProductRepository.findById(id);
        if (byId.isPresent()){
            OutputProduct outputProduct = byId.get();
            return outputProduct;
        }
        return new OutputProduct();
    }

    public Result put(Integer id,OutputProductDto dto){
        Optional<OutputProduct> outputProductRepositoryById = outputProductRepository.findById(id);
        if (!outputProductRepositoryById.isPresent()){
            return new Result("Bunday output product yoq",false);
        }
        Optional<Product> optionalProduct = productRepository.findById(dto.getProductId());
        if (!optionalProduct.isPresent()){
            return new Result("Bunday  product yoq",false);
        }
        Optional<Output> optionalOutput = outputRepositroy.findById(dto.getOutputId());
        if (!optionalOutput.isPresent()){
            return new Result("Bunday output  yoq",false);
        }
        OutputProduct outputProduct = outputProductRepositoryById.get();
        outputProduct.setProduct(optionalProduct.get());
        outputProduct.setOutput(optionalOutput.get());
        outputProduct.setPrice(dto.getPrice());
        outputProduct.setAmount(dto.getAmount());
        outputProductRepository.save(outputProduct);
        return new Result(" output product saqlandi",true);

    }

}
