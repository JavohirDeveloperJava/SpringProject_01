package com.example.springproject_01.service;

import com.example.springproject_01.entity.Clent;
import com.example.springproject_01.entity.Currency;
import com.example.springproject_01.entity.Output;
import com.example.springproject_01.entity.Warehouse;
import com.example.springproject_01.payload.OutputDto;
import com.example.springproject_01.payload.Result;
import com.example.springproject_01.repository.ClentRepository;
import com.example.springproject_01.repository.CurrencyRepositriy;
import com.example.springproject_01.repository.OutputRepositroy;
import com.example.springproject_01.repository.WarehouseRepositroy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;

@Service
public class OutputService {
    @Autowired
    OutputRepositroy outputRepositroy;
    @Autowired
    WarehouseRepositroy warehouseRepositroy;
    @Autowired
    CurrencyRepositriy currencyRepositriy;
    @Autowired
    ClentRepository clentRepository;

    public Result add(OutputDto dto){
        Optional<Warehouse> optionalWarehouse = warehouseRepositroy.findById(dto.getWarehouseId());
        if (!optionalWarehouse.isPresent()){
            return new Result("Bunday warehouse mavjut emas",false);
        }
        Optional<Currency> optionalCurrency = currencyRepositriy.findById(dto.getCurrencyId());
        if (!optionalCurrency.isPresent()){
            return new Result("Bunday currency mavjut emas",false);
        }
        Optional<Clent> optionalClent = clentRepository.findById(dto.getClentId());
        if (!optionalClent.isPresent()){
            return new Result("Bunday clent mavjut emas",false);
        }

        Output output=new Output();
        output.setDate(new Timestamp(dto.getDate()));
        output.setWarehouse(optionalWarehouse.get());
        output.setCurrency(optionalCurrency.get());
        output.setCode(generateCode("output"));
        output.setFacturaNumber(dto.getFacturaNumber());
        output.setClent(optionalClent.get());
        outputRepositroy.save(output);
        return new Result("Output saqlandi",true);

    }
    private static String generateCode(String name){
        double random=Math.random()*100000;
        return (random-random%1)+"#"+name;
    }

    public List<Output> get(){
        return outputRepositroy.findAll();
    }

    public Result delete(Integer id){
        Optional<Output> optionalOutput = outputRepositroy.findById(id);
        if (!optionalOutput.isPresent()){
            return new Result("Bunday output yoq",false);
        }
        outputRepositroy.deleteById(id);
        return new Result(" output ochdi",true);
    }

    public Result put(Integer id,OutputDto dto){
        Optional<Output> optionalOutput = outputRepositroy.findById(id);
        if (!optionalOutput.isPresent()){
            return new Result("Bunday output yoq",false);
        }
        Optional<Clent> optionalClent = clentRepository.findById(dto.getClentId());
        if (!optionalClent.isPresent()){
            return new Result("Bunday clent yoq",false);
        }
        Optional<Currency> optionalCurrency = currencyRepositriy.findById(dto.getCurrencyId());
        if (!optionalCurrency.isPresent()){
            return new Result("Bunday currency yoq",false);
        }
        Optional<Warehouse> optionalWarehouse = warehouseRepositroy.findById(dto.getWarehouseId());
        if (!optionalWarehouse.isPresent()){
            return new Result("Bunday warehouse yoq",false);
        }
        Output output = optionalOutput.get();
        output.setClent(optionalClent.get());
        output.setCurrency(optionalCurrency.get());
        output.setWarehouse(optionalWarehouse.get());
        output.setCode(dto.getCode());
        output.setFacturaNumber(dto.getFacturaNumber());
        output.setDate(new Timestamp(dto.getDate()));
        outputRepositroy.save(output);
        return new Result(" output ozgardi",true);
    }
}
