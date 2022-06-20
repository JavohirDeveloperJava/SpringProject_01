package com.example.springproject_01.service;

import com.example.springproject_01.entity.User;
import com.example.springproject_01.entity.Warehouse;
import com.example.springproject_01.payload.Result;
import com.example.springproject_01.payload.UserDto;
import com.example.springproject_01.repository.UserRepositroy;
import com.example.springproject_01.repository.WarehouseRepositroy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    UserRepositroy userRepositroy;

    @Autowired
    WarehouseRepositroy warehouseRepositroy;

    public Result add(UserDto dto){
        boolean exists = userRepositroy.existsByPhoneNumber(dto.getPhoneNumber());
        if (exists){
            return new Result("Bunday phone numberlik user mavjut",false);
        }
        List<Warehouse> allById = warehouseRepositroy.findAllById(dto.getWarehousesId());

        User user=new User();
        user.setFirstName(dto.getFirstName());
        user.setLastName(dto.getLastName());
        user.setPhoneNumber(dto.getPhoneNumber());
        user.setPassword(dto.getPassword());
        user.setWarehouses(allById);
        user.setCode(dto.getCode());
        userRepositroy.save(user);
        return new Result("User saqlandi",true);


    }

    public List<User> get(){
        return userRepositroy.findAll();
    }


    public Result delet(Integer id){
        Optional<User> optionalUser = userRepositroy.findById(id);
        if (optionalUser.isPresent()){
            userRepositroy.deleteById(id);
            return new Result("User ochdi",true);
        }
        return new Result("Hatolik ochmadi",false);
    }

    public Result put(Integer id,UserDto dto){
        Optional<User> optionalUser = userRepositroy.findById(id);
        if (!optionalUser.isPresent()){
            return new Result("Bunday user mavjut emas",false);
        }
        boolean exists = userRepositroy.existsByPhoneNumber(dto.getPhoneNumber());
        if (exists){
            return new Result("Bunday phone numberlik user mavjut",false);
        }

        boolean exists1 = userRepositroy.existsByCode(dto.getCode());
        if (exists1){
            return new Result("Bunday codelik user mavjut ozgartiring",false);
        }
        List<Warehouse> allById = warehouseRepositroy.findAllById(dto.getWarehousesId());

        User user = optionalUser.get();
        user.setFirstName(dto.getFirstName());
        user.setLastName(dto.getLastName());
        user.setPhoneNumber(dto.getPhoneNumber());
        user.setCode(dto.getCode());
        user.setWarehouses(allById);
        userRepositroy.save(user);
        return new Result("User ozgardi",true);
    }

    public User hetId(Integer id){
        Optional<User> optionalUser = userRepositroy.findById(id);
        if (optionalUser.isPresent()){
            User user = optionalUser.get();
            return user;
        }
        return new User();
    }
}
