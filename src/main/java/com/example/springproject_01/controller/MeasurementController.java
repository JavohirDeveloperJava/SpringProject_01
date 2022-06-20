package com.example.springproject_01.controller;

import com.example.springproject_01.entity.Measurement;
import com.example.springproject_01.payload.Result;
import com.example.springproject_01.service.MeasurementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping("/measurement")
public class MeasurementController { //olchov birligi

    @Autowired
    MeasurementService measurementService;

    @PostMapping
    public Result addMeasurement(@RequestBody Measurement measurement){
        Result result = measurementService.addService(measurement);
        return  result;
    }

    @GetMapping
    public List<Measurement> get(){
        return measurementService.get();
    }

    @DeleteMapping("/delet/{id}")
    public Result delet(@PathVariable Integer id){
        return measurementService.delet(id);
    }

    @PutMapping("/put/{id}")
    public Result put(@PathVariable Integer id,@RequestBody Measurement measurement){
        return measurementService.put(id, measurement);
    }

}
