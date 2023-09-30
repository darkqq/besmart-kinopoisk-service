package com.besmartkinopoiskservice.service;

import com.besmartkinopoiskservice.exception.ServiceException;
import com.besmartkinopoiskservice.to.request.movie.CreateMovieRequestTO;
import com.besmartkinopoiskservice.to.response.EmptyResponseTO;
import com.besmartkinopoiskservice.to.response.movie.MovieDetailsResponseTO;
import com.besmartkinopoiskservice.to.response.movie.MovieListResponseTO;

import java.util.UUID;

public interface MovieService {
    EmptyResponseTO addMovieToDatabase(CreateMovieRequestTO request) throws ServiceException;

    MovieDetailsResponseTO findMovie(UUID movieId) throws ServiceException;

    MovieListResponseTO findMoviesList(String title, Integer year, String sortType, int pageSize, int offset) throws ServiceException;
}
