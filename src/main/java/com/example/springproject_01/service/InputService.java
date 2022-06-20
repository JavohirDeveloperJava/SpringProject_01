package com.example.springproject_01.service;

import com.example.springproject_01.entity.Currency;
import com.example.springproject_01.entity.Input;
import com.example.springproject_01.entity.Supplier;
import com.example.springproject_01.entity.Warehouse;
import com.example.springproject_01.payload.InputDto;
import com.example.springproject_01.payload.Result;
import com.example.springproject_01.repository.CurrencyRepositriy;
import com.example.springproject_01.repository.InputRepository;
import com.example.springproject_01.repository.SupplierRepositroy;
import com.example.springproject_01.repository.WarehouseRepositroy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.sql.Date;
import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;

@Service
public class InputService {

    @Autowired
    InputRepository inputRepository;
    @Autowired
    CurrencyRepositriy currencyRepositriy;
    @Autowired
    SupplierRepositroy supplierRepositroy;
    @Autowired
    WarehouseRepositroy warehouseRepositroy;

    public Result add(InputDto dto){
        Optional<Currency> optionalCurrency = currencyRepositriy.findById(dto.getCurrencyId());
        if (!optionalCurrency.isPresent()){
            return new Result("Bunday currency mavjut emas",false);
        }
        Optional<Supplier> optionalSupplier = supplierRepositroy.findById(dto.getSupplierId());
        if (!optionalCurrency.isPresent()){
            return new Result("Bunday supplier mavjut emas",false);
        }
        Optional<Warehouse> optionalWarehouse = warehouseRepositroy.findById(dto.getWarehouseId());
        if (!optionalWarehouse.isPresent()){
            return new Result("Bunday warehouse mavjut emas",false);
        }
        String code = dto.getCode();



        Input input=new Input();
        input.setCurrency(optionalCurrency.get());
        input.setSupplier(optionalSupplier.get());
        input.setWarehouse(optionalWarehouse.get());
        input.setFacturaNumber(dto.getFacturaNumber());
        input.setCode(code);
        input.setDate(dto.getDate());
        inputRepository.save(input);
        return new Result("Inpu saqlandi",true);
    }

    public List<Input> get(){
        return inputRepository.findAll();
    }

    public Result delet(Integer id){
        Optional<Input> optionalInput = inputRepository.findById(id);
        if (optionalInput.isPresent()){
            inputRepository.deleteById(id);
            return new Result("Input ochdi",true);
        }
        return new Result("Input ochdimadi hatolik",false);
    }

    public Input getId(Integer id){
        Optional<Input> optionalInput = inputRepository.findById(id);
        if (optionalInput.isPresent()){
            Input input = optionalInput.get();
            return input;
        }
        return new Input();
    }
    public Result put(Integer id,InputDto dto){
        Optional<Input> optionalInput = inputRepository.findById(id);
        if (!optionalInput.isPresent()){
            return new Result("Bunday input yoq",false);
        }
        Optional<Currency> optionalCurrency = currencyRepositriy.findById(dto.getCurrencyId());
        if (!optionalCurrency.isPresent()){
            return new Result("Bunday currency yoq",false);
        }
        Optional<Supplier> optionalSupplier = supplierRepositroy.findById(dto.getSupplierId());
        if (!optionalSupplier.isPresent()){
            return new Result("Bunday supplier yoq",false);
        }
        Optional<Warehouse> optionalWarehouse = warehouseRepositroy.findById(dto.getWarehouseId());
        if (!optionalWarehouse.isPresent()){
            return new Result("Bunday warehouse yoq",false);
        }
        Input input = optionalInput.get();
        input.setDate(dto.getDate());
        input.setCode(dto.getCode());
        input.setCurrency(optionalCurrency.get());
        input.setSupplier(optionalSupplier.get());
        input.setWarehouse(optionalWarehouse.get());
        input.setFacturaNumber(dto.getFacturaNumber());
        inputRepository.save(input);
        return new Result("input ozgardi",true);
    }



}
