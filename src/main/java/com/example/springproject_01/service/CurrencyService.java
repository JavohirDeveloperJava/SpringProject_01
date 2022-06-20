package com.example.springproject_01.service;

import com.example.springproject_01.payload.Result;
import com.example.springproject_01.repository.CurrencyRepositriy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;


import java.util.List;
import java.util.Optional;
import com.example.springproject_01.entity.Currency;
@Service
public class CurrencyService {
    @Autowired
    CurrencyRepositriy currencyRepositriy;

    public Result add(@RequestBody Currency currency){
        boolean existsByName = currencyRepositriy.existsByName(currency.getName());
        if (existsByName){
            return new Result("Bunday currency mavjut",false);
        }
        Currency currency1=new Currency();
        currency1.setName(currency.getName());
        currencyRepositriy.save(currency1);
        return new Result("Currensy saqlandi",true);
    }
    public List<Currency> get(){
        return currencyRepositriy.findAll();
    }

    public Result delet(Integer id){
        Optional<Currency> optionalCurrency = currencyRepositriy.findById(id);
        if (optionalCurrency.isPresent()){
            currencyRepositriy.deleteById(id);
            return new Result("Currency ochdi",true);
        }
        return new Result("hatolik ", false);
    }
    public Result put(Integer id, Currency currency){
        Optional<Currency> optionalCurrency = currencyRepositriy.findById(id);
        if (!optionalCurrency.isPresent()){
            return new Result("Bunday currency mavjut emas",false);
        }
        Currency currency1 = optionalCurrency.get();
        currency1.setName(currency.getName());
        currencyRepositriy.save(currency1);
        return new Result("currency ozgardi",true);
    }
}
