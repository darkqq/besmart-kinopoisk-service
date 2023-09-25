package com.besmartkinopoiskservice.service.impl;

import com.besmartkinopoiskservice.domain.MovieEntity;
import com.besmartkinopoiskservice.exception.ServiceException;
import com.besmartkinopoiskservice.repository.ImageRepository;
import com.besmartkinopoiskservice.repository.MovieRepository;
import com.besmartkinopoiskservice.service.ResourceService;
import com.besmartkinopoiskservice.to.response.EmptyResponseTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ResourceServiceImpl implements ResourceService {
    private final ImageRepository imageRepository;
    private final MovieRepository movieRepository;

    @Override
    public ResponseEntity<byte[]> getMovieImage(UUID imageId) throws ServiceException {
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
    public EmptyResponseTO updateMovieImage(UUID movieId, MultipartFile image) throws ServiceException {
        Optional<MovieEntity> movie = movieRepository.findById(movieId);
        if (movie.get().getImage() != null) {
            try {
                imageRepository.saveImage(image, movie.get().getImage());
            } catch (IOException e) {
                throw new ServiceException("Ошибка при обновлении постера");
            }
        } else {
            UUID imageId = UUID.randomUUID();
            try {
                imageRepository.saveImage(image, imageId);
            } catch (IOException e) {
                throw new ServiceException("Ошибка при сохранении постера");
            }
            movie.get().setImage(imageId);
        }
        movieRepository.save(movie.get());

        return new EmptyResponseTO();
    }
}
