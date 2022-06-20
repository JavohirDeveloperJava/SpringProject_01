package com.example.springproject_01.controller;

import com.example.springproject_01.payload.Result;
import com.example.springproject_01.service.AttechmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartHttpServletRequest;


@RestController
@RequestMapping("/attechment")
public class AttechmentController {
    @Autowired
    AttechmentService attechmentService;
    @PostMapping("/uploadd")
    public Result uploadFile(MultipartHttpServletRequest request){
        return attechmentService.add(request);
    }
}
