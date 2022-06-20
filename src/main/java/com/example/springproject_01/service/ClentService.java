package com.example.springproject_01.service;

import com.example.springproject_01.entity.Clent;
import com.example.springproject_01.payload.ClentDto;
import com.example.springproject_01.payload.Result;
import com.example.springproject_01.repository.ClentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;

@Service
public class ClentService {

    @Autowired
    ClentRepository clentRepository;

    public Result addd(ClentDto dto){
        boolean exists = clentRepository.existsByPhoneNumber(dto.getPhoneNumber());
        if (exists){
            return new Result("Bunday phone nomberlik clent mavjut",false);
        }
        Clent clent=new Clent();
        clent.setName(dto.getName());
        clent.setPhoneNumber(dto.getPhoneNumber());
        clentRepository.save(clent);
        return new Result("Clent saqlandi",true);

    }

    public List<Clent> get(){
        return clentRepository.findAll();
    }

    public Clent getId(Integer id){
        Optional<Clent> optionalClent = clentRepository.findById(id);
        if (optionalClent.isPresent()){
            Clent clent = optionalClent.get();
            return clent;
        }
        return new Clent();
    }

    public Result delet(Integer id){
        Optional<Clent> optionalClent = clentRepository.findById(id);
        if (optionalClent.isPresent()){
            clentRepository.deleteById(id);
            return new Result("Clent ochdi",true);
        }
        return new Result("Hatolik ochmadi",false);
    }

    public Result put(Integer id,ClentDto dto){
        Optional<Clent> optionalClent = clentRepository.findById(id);
        if (!optionalClent.isPresent()){
            return new Result("Bunday klent mavjut emas",false);
        }
        Clent clent = optionalClent.get();
        clent.setName(dto.getName());
        clent.setPhoneNumber(dto.getPhoneNumber());
        clentRepository.save(clent);
        return new Result("Clent ozgardi",true);
    }
}
