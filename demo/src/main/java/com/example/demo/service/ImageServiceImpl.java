package com.example.demo.service;

import com.example.demo.Entity.ImageEntity;
import com.example.demo.Entity.QImageEntity;
import com.example.demo.repository.ImageRepository;
import com.querydsl.core.types.Predicate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

@Service
public class ImageServiceImpl implements ImageService {
    ImageRepository imageRepository;

    @Value("${urls.imageUrl}")
    private String url;

    @Autowired
    public ImageServiceImpl(ImageRepository imageRepository) {
        this.imageRepository = imageRepository;
    }

    @Override
    public void saveImage(String code) {
        String imageUrl = url + code + ".gif";
        URL url = null;

        try {
            url = new URL(imageUrl);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        ByteArrayOutputStream output = new ByteArrayOutputStream();

        try (InputStream inputStream = url.openStream()) {
            int n = 0;
            byte[] buffer = new byte[1024];
            while (-1 != (n = inputStream.read(buffer))) {
                output.write(buffer, 0, n);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        ImageEntity imageEntity = new ImageEntity(output.toByteArray(), code);
        imageRepository.save(imageEntity);
    }

    @Override
    @Transactional
    public List<ImageEntity> getImage(String code) {
        QImageEntity imageEntity = QImageEntity.imageEntity;
        Predicate isCodeEquals = imageEntity.kod.eq(code);
        Iterable<ImageEntity> imageEntities = imageRepository.findAll(isCodeEquals);

        return (List<ImageEntity>) imageEntities;
    }

    @Override
    @Transactional
    public boolean isEmpty(String code) {
        return getImage(code).isEmpty();
    }
}
