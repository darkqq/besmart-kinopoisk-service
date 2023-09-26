package com.besmartkinopoiskservice.controller;

import com.besmartkinopoiskservice.exception.ServiceException;
import com.besmartkinopoiskservice.service.ResourceService;
import com.besmartkinopoiskservice.to.response.ResourceResponseTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.UUID;

@RestController
@RequestMapping("/resource")
@RequiredArgsConstructor
public class ResourceController {
    private final ResourceService resourceService;

    @GetMapping("/image/movie/{imageId}")
    public ResponseEntity<byte[]> getMovieImage(@PathVariable UUID imageId) throws ServiceException {
        return resourceService.getResource(imageId);
    }

    @PutMapping("/image/movie/update")
    public ResponseEntity<ResourceResponseTO> updateMovieImage(@RequestParam("image") MultipartFile image) throws ServiceException {
        return ResponseEntity.ok(resourceService.uploadResource(image));
    }
}
