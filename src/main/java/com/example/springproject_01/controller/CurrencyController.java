package com.example.springproject_01.controller;

import com.example.springproject_01.entity.Currency;
import com.example.springproject_01.payload.Result;
import com.example.springproject_01.service.CurrencyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;



import java.util.List;

@RestController
@RequestMapping("/curren")
public class CurrencyController {

    @Autowired
    CurrencyService currencyService;

    @PostMapping
    public Result add(@RequestBody Currency currency){
        return currencyService.add(currency);
    }

    @GetMapping
    public List<Currency> get(){
        return currencyService.get();
    }

    @DeleteMapping("/delet/{id}")
    public Result delet(@PathVariable Integer id){
        return currencyService.delet(id);
    }

    @PutMapping("/put/{id}")
    public Result put(@PathVariable Integer id, @RequestBody Currency currency){
        return currencyService.put(id, currency);
    }
}
