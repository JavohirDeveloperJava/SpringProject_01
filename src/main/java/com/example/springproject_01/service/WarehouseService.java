package com.example.springproject_01.service;

import com.example.springproject_01.entity.Warehouse;
import com.example.springproject_01.payload.Result;
import com.example.springproject_01.repository.WarehouseRepositroy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;

@Service
public class WarehouseService {
    @Autowired
    WarehouseRepositroy warehouseRepositroy;

    public Result add(Warehouse warehouse){
        boolean exists = warehouseRepositroy.existsByName(warehouse.getName());
        if (exists){
            return new Result("Bunday ombor mavjut",false);
        }
        Warehouse warehouse1=new Warehouse();
        warehouse1.setName(warehouse.getName());
        warehouseRepositroy.save(warehouse1);
        return new Result("Warehouse saqlandi",true);

    }

    public List<Warehouse> get(){
        return warehouseRepositroy.findAll();
    }

    public Result delet(Integer id){
        Optional<Warehouse> optionalWarehouse = warehouseRepositroy.findById(id);
        if (optionalWarehouse.isPresent()){
            warehouseRepositroy.deleteById(id);
            return new Result("warehouse ochdi",true);
        }
        return new Result("hatolik ochmadi",false);
    }

    public Result put(Integer id, Warehouse warehouse){
        Optional<Warehouse> optionalWarehouse = warehouseRepositroy.findById(id);
        if (optionalWarehouse.isPresent()){
            boolean exists = warehouseRepositroy.existsByName(warehouse.getName());
            if (exists){
                return new Result("Bunday nomlik ombor bor",false);
            }
            Warehouse warehouse1 = optionalWarehouse.get();
            warehouse1.setName(warehouse.getName());
            warehouseRepositroy.save(warehouse1);
            return new Result("Warehouse Ozgardi",true);

        }
        return new Result("Bunday ombor Mavjud emas",false);
    }

    public Warehouse getId(Integer id){
        Optional<Warehouse> optionalWarehouse = warehouseRepositroy.findById(id);
        if (optionalWarehouse.isPresent()){
            Warehouse warehouse = optionalWarehouse.get();
            return warehouse;
        }
        return new Warehouse();
    }
}
