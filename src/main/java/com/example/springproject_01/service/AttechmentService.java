package com.example.springproject_01.service;

import com.example.springproject_01.entity.Attechment;
import com.example.springproject_01.entity.AttechmentContent;
import com.example.springproject_01.payload.Result;
import com.example.springproject_01.repository.AttechmentContentRepositroy;
import com.example.springproject_01.repository.AttechmentRepository;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;


import java.util.Iterator;

@Service
public class AttechmentService {

    @Autowired
    AttechmentRepository attechmentRepository;

    @Autowired
    AttechmentContentRepositroy attechmentContentRepositroy;


    @SneakyThrows
    public Result add(MultipartHttpServletRequest request) {
        Iterator<String> fileNames = request.getFileNames();
        MultipartFile file = request.getFile(fileNames.next());
        if (file != null) {
            String originalFilename = file.getOriginalFilename();
            long size = file.getSize();
            String contentType = file.getContentType();
            Attechment attachment = new Attechment();
            attachment.setOriginalName(originalFilename);
            attachment.setContentType(contentType);
            attachment.setSize(size);
            Attechment save = attechmentRepository.save(attachment);

            AttechmentContent attechmentConten = new AttechmentContent();
            attechmentConten.setBytes(file.getBytes());
            attechmentConten.setAttechment(save);
            attechmentContentRepositroy.save(attechmentConten);
            return new Result("File saqlandi", true, save.getId());

        }
        return new Result("Saqlanmadi", false);
    }


}
