package com.besmartkinopoiskservice.service;

import com.besmartkinopoiskservice.exception.ServiceException;
import com.besmartkinopoiskservice.to.request.movie.CreateMovieRequestTO;
import com.besmartkinopoiskservice.to.response.EmptyResponseTO;
import com.besmartkinopoiskservice.to.response.movie.MovieDetailsResponseTO;
import com.besmartkinopoiskservice.to.response.movie.MovieListResponseTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

import java.util.UUID;

public interface MovieService {
    EmptyResponseTO addMovieToDatabase(CreateMovieRequestTO request) throws ServiceException;

    MovieDetailsResponseTO findMovie(UUID movieId) throws ServiceException;

    MovieListResponseTO findMoviesShortDetails(String title, Integer year, String sortType, int pageSize, int offset);
}
