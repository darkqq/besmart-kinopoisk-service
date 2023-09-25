package com.besmartkinopoiskservice.controller;

import com.besmartkinopoiskservice.exception.ServiceException;
import com.besmartkinopoiskservice.service.ResourceService;
import com.besmartkinopoiskservice.to.response.EmptyResponseTO;
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
        return resourceService.getMovieImage(imageId);
    }

    @PutMapping("/image/movie/update")
    public ResponseEntity<EmptyResponseTO> updateMovieImage(@RequestParam("movieid") UUID movieId, @RequestParam("image") MultipartFile image) throws ServiceException {
        return ResponseEntity.ok(resourceService.updateMovieImage(movieId, image));
    }
}
