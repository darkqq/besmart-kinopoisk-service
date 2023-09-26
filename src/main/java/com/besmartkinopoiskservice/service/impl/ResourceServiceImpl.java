package com.besmartkinopoiskservice.service.impl;

import com.besmartkinopoiskservice.exception.ServiceException;
import com.besmartkinopoiskservice.repository.ImageRepository;
import com.besmartkinopoiskservice.repository.MovieRepository;
import com.besmartkinopoiskservice.service.ResourceService;
import com.besmartkinopoiskservice.to.response.ResourceResponseTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ResourceServiceImpl implements ResourceService {
    private final ImageRepository imageRepository;

    @Override
    public ResponseEntity<byte[]> getResource(UUID imageId) throws ServiceException {
        byte[] imageBytes;
        try {
            imageBytes = imageRepository.getImage(imageId);
        } catch (IOException e) {
            throw new ServiceException("Проблема при получении постера фильма");
        } catch (Exception e) {
            throw new ServiceException("Постера для запрашиваемого фильма не существует");
        }

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.IMAGE_JPEG);
        headers.setContentLength(imageBytes.length);
        return new ResponseEntity<>(imageBytes, headers, HttpStatus.OK);
    }

    @Override
    public ResourceResponseTO uploadResource(MultipartFile image) throws ServiceException {
        UUID imageId = UUID.randomUUID();
        try {
            imageRepository.saveImage(image, imageId);
        } catch (IOException e) {
            throw new ServiceException("Ошибка при сохранении постера");
        }
        return new ResourceResponseTO();
    }
}
