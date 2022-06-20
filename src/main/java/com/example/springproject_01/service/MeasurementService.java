package com.example.springproject_01.service;

import com.example.springproject_01.entity.Measurement;
import com.example.springproject_01.payload.Result;
import com.example.springproject_01.repository.MeasurementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;

@Service
public class MeasurementService {// olcov birligi

    @Autowired
    MeasurementRepository measurementRepository;

    public Result addService(Measurement measurement){
        boolean byName = measurementRepository.existsByName(measurement.getName());
        if (byName){
            return new Result("bunday olchov birligi mavjut",false);
        }

        measurementRepository.save(measurement);
        return new Result("muofaqiyatli saqlandi",true);
    }

    public List<Measurement> get(){
        return measurementRepository.findAll();
    }

    public Result delet(Integer id){
        Optional<Measurement> optionalMeasurement = measurementRepository.findById(id);
        if (optionalMeasurement.isPresent()){
            measurementRepository.deleteById(id);
            return new Result("measurement ochdi",true);
        }
        return new Result("hatolik ochmadi",false);
    }

    public Result put(Integer id, Measurement measurement){
        Optional<Measurement> optionalMeasurement = measurementRepository.findById(id);
        if (!optionalMeasurement.isPresent()){
            return new Result("Bunday measurement yoq",false);
        }
        Measurement measurement1 = optionalMeasurement.get();
        measurement1.setName(measurement.getName());
        measurementRepository.save(measurement1);
        return new Result("Measurement ozgardi",true);
    }
}
