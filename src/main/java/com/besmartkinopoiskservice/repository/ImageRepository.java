package com.besmartkinopoiskservice.repository;

import org.springframework.stereotype.Repository;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.UUID;

@Repository
public interface ImageRepository {

    void saveImage(MultipartFile image, UUID imageId) throws IOException;

    byte[] getImage(UUID imageId) throws IOException;
}
