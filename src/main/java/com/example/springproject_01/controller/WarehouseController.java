package com.example.springproject_01.controller;

import com.example.springproject_01.entity.Warehouse;
import com.example.springproject_01.payload.Result;
import com.example.springproject_01.service.WarehouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping("/wer")
public class WarehouseController {
    @Autowired
    WarehouseService warehouseService;
    @PostMapping
    public Result add(@RequestBody Warehouse warehouse){
        return warehouseService.add(warehouse);
    }

    @GetMapping
    public List<Warehouse> get(){
        return warehouseService.get();
    }

    @DeleteMapping("/delet/{id}")
    public Result delet(@PathVariable Integer id){
        return warehouseService.delet(id);
    }
    @PutMapping("/put/{id}")
    public Result put(@PathVariable Integer id, @RequestBody Warehouse warehouse){
        return warehouseService.put(id, warehouse);
    }
    @GetMapping("/get/{id}")
    public Warehouse getId(@PathVariable Integer id){
        return warehouseService.getId(id);
    }
}
