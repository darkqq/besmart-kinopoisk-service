package com.besmartkinopoiskservice.repository;

import org.springframework.mock.web.MockMultipartFile;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.support.StandardMultipartHttpServletRequest;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.UUID;

public class ImageRepository {

    private final String filePath = "C:/Users/makseke/Desktop/img/";
    public void saveImage(MultipartFile image, UUID imageId) throws IOException {
        File file = new File(filePath + imageId + ".jpg");
        image.transferTo(file);
    }

    public MultipartFile getImage(UUID imageId) throws IOException {
        File file = new File(filePath + imageId + ".jpg");
        FileInputStream input = new FileInputStream(file);
        MultipartFile image = new MockMultipartFile(file.getName(), input);
        return image;
    }
}
