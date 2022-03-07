package com.example.demo.controller;

import com.example.demo.Entity.ImageEntity;
import com.example.demo.service.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ImageController {
    ImageService imageService;

    @Autowired
    public ImageController(ImageService imageService) {
        this.imageService = imageService;
    }

    @GetMapping(value = "image/get/{currCode}",
            produces = MediaType.IMAGE_GIF_VALUE)
    public byte[] getImage(@PathVariable String currCode) {
        if(imageService.isEmpty(currCode))
            imageService.saveImage(currCode);
        List<ImageEntity> x = imageService.getImage(currCode);
        return x.get(0).getFlag();
    }

    @GetMapping(value = "image/save/{currCode}")
    public void saveImage(@PathVariable String currCode) {
        imageService.saveImage(currCode);
    }
}
