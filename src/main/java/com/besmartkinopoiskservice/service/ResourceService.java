package com.besmartkinopoiskservice.service;

import com.besmartkinopoiskservice.exception.ServiceException;
import com.besmartkinopoiskservice.to.response.EmptyResponseTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

import java.util.UUID;

public interface ResourceService {
    ResponseEntity<byte[]> getMovieImage(UUID imageId) throws ServiceException;

    EmptyResponseTO updateMovieImage(UUID movieId, MultipartFile image) throws ServiceException;
}
