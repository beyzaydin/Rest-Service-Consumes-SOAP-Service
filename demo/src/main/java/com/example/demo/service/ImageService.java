package com.example.demo.service;

import com.example.demo.Entity.ImageEntity;

import java.util.List;

public interface ImageService {
    void saveImage(String code);

    List<ImageEntity> getImage(String code);

    boolean isEmpty(String code);
}
