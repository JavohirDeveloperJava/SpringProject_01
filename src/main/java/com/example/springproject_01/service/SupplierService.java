package com.example.springproject_01.service;

import com.example.springproject_01.entity.Supplier;
import com.example.springproject_01.payload.Result;
import com.example.springproject_01.payload.SupplierDto;
import com.example.springproject_01.repository.SupplierRepositroy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;

@Service
public class SupplierService {
    @Autowired
    SupplierRepositroy supplierRepositroy;

    public Result add(SupplierDto dto){
        boolean exists = supplierRepositroy.existsByPhoneNumber(dto.getPhoneNumber());
        if (exists){
            return new Result("Bunday suppler bor",false);
        }
        Supplier supplier=new Supplier();
        supplier.setName(dto.getName());
        supplier.setPhoneNumber(dto.getPhoneNumber());
        supplierRepositroy.save(supplier);
        return new Result("Supplier saqlandi",true);
    }

    public List<Supplier> get(){
        return supplierRepositroy.findAll();
    }

    public Result delet(Integer id){
        Optional<Supplier> optionalSupplier = supplierRepositroy.findById(id);
        if (optionalSupplier.isPresent()){
            supplierRepositroy.deleteById(id);
            return new Result("Suppler ochdi",true);
        }
        return new Result("hatolik ochmadi",false);
    }
    public Result put(Integer id,SupplierDto dto){
        boolean exists = supplierRepositroy.existsByPhoneNumber(dto.getPhoneNumber());
        if (exists){
            return new Result("Bunday phone number mavjut",false);
        }
        Optional<Supplier> optionalSupplier = supplierRepositroy.findById(id);
        if (!optionalSupplier.isPresent()){
            return new Result("Bunday supplier mavjut emas",false);
        }
        Supplier supplier = optionalSupplier.get();
        supplier.setName(dto.getName());
        supplier.setPhoneNumber(dto.getPhoneNumber());
        supplierRepositroy.save(supplier);
        return new Result("Supplier ozgartirildi",true);
    }
}
