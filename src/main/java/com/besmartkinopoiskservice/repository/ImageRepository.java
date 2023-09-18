package com.besmartkinopoiskservice.repository;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.UUID;

@Component
public interface ImageRepository {

    void saveImage(MultipartFile image, UUID imageId) throws IOException;

    byte[] getImage(UUID imageId) throws IOException;
}
