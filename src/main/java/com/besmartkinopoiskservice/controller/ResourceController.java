package com.besmartkinopoiskservice.controller;

import com.besmartkinopoiskservice.exception.ServiceException;
import com.besmartkinopoiskservice.service.ResourceService;
import com.besmartkinopoiskservice.to.response.ResourceResponseTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.UUID;

@RestController
@RequestMapping("/resource")
@RequiredArgsConstructor
public class ResourceController {
    private final ResourceService resourceService;

    @GetMapping("/{imageId}")
    public ResponseEntity<byte[]> getMovieImage(@PathVariable UUID imageId) throws ServiceException {
        byte[] imageBytes = resourceService.getResource(imageId);
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.IMAGE_JPEG);
        headers.setContentLength(imageBytes.length);
        return ResponseEntity.ok().headers(headers).body(imageBytes);
    }

    @PutMapping("/update")
    public ResponseEntity<ResourceResponseTO> updateMovieImage(@RequestParam("image") MultipartFile image) throws ServiceException {
        return ResponseEntity.ok(resourceService.uploadResource(image));
    }
}
