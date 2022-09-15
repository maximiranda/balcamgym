package com.example.balcamgym.Controllers;

import com.example.balcamgym.Models.ImgFile;
import com.example.balcamgym.Repositories.ImgFIleRepository;
import com.example.balcamgym.Services.ImgFIleServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;


import java.util.List;



@RestController
@RequestMapping("/api")
public class ImgFileController {
    @Autowired
    private ImgFIleServices imgFIleServices;
    @Autowired
    private ImgFIleRepository imgFIleRepository;

    @PostMapping("/upload")
    public ResponseEntity<Object> setImg(@RequestParam("file") MultipartFile multipartFile){
        try {
            imgFIleServices.save(multipartFile);
            return new ResponseEntity<>("Uploaded", HttpStatus.CREATED);
        } catch (Exception e){
            System.out.println(e);
            return new ResponseEntity<>("Not upload", HttpStatus.EXPECTATION_FAILED);
        }
    }
    @GetMapping("/images")
    public List<ImgFile> getListFiles() {
        return imgFIleRepository.findAll();
    }
}
