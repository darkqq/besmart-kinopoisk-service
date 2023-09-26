package com.besmartkinopoiskservice.service;

import com.besmartkinopoiskservice.exception.ServiceException;
import com.besmartkinopoiskservice.to.response.ResourceResponseTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

import java.util.UUID;

public interface ResourceService {
    ResponseEntity<byte[]> getResource(UUID imageId) throws ServiceException;

    ResourceResponseTO uploadResource(MultipartFile image) throws ServiceException;
}
