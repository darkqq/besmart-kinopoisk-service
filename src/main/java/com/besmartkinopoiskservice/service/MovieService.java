package com.besmartkinopoiskservice.service;

import com.besmartkinopoiskservice.exception.ServiceException;
import com.besmartkinopoiskservice.to.request.movie.CreateMovieRequestTO;
import com.besmartkinopoiskservice.to.response.EmptyResponseTO;
import com.besmartkinopoiskservice.to.response.movie.GetMovieResponseTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.UUID;

public interface MovieService {
    EmptyResponseTO addMovieToDatabase(CreateMovieRequestTO request) throws ServiceException;

    GetMovieResponseTO getMovie(String title) throws ServiceException, IOException;

    GetMovieResponseTO findMovies(String title, Integer year, String sortType, int pageSize, int offset) throws ServiceException, IOException;

    EmptyResponseTO updateMovieImage(UUID movieId, MultipartFile image) throws ServiceException;

    ResponseEntity<byte[]> getMovieImage(UUID movieId) throws ServiceException;
}
