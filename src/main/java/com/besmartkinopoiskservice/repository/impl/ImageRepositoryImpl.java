package com.besmartkinopoiskservice.repository.impl;

import com.besmartkinopoiskservice.repository.ImageRepository;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.UUID;

@Component
public class ImageRepositoryImpl implements ImageRepository {

    private final String filePath = new File("").getAbsolutePath() + "/src/main/resources/img/";

    @Override
    public void saveImage(MultipartFile image, UUID imageId) throws IOException {
        File file = new File(filePath + imageId + ".jpg");
        image.transferTo(file);
    }

    @Override
    public byte[] getImage(UUID imageId) throws IOException {
        Path imagePath = Paths.get(filePath + imageId + ".jpg");
        byte[] imageBytes = Files.readAllBytes(imagePath);
        return imageBytes;
    }
}
