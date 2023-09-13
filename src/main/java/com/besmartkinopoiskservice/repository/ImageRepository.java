package com.besmartkinopoiskservice.repository;

import org.springframework.mock.web.MockMultipartFile;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.UUID;

public class ImageRepository {

    private final String filePath = "C:/Users/makseke/Desktop/img/";

    public void saveImage(MultipartFile image, UUID imageId) throws IOException {
        File file = new File(filePath + imageId + ".jpg");
        image.transferTo(file);
    }

    public byte[] getImage(UUID imageId) throws IOException {
        Path imagePath = Paths.get(filePath + imageId + ".jpg");
        byte[] imageBytes = Files.readAllBytes(imagePath);
        return imageBytes;
    }
}
