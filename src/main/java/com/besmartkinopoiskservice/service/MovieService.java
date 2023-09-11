package com.besmartkinopoiskservice.service;

import com.besmartkinopoiskservice.exception.ServiceException;
import com.besmartkinopoiskservice.to.request.movierequest.CreateMoviePageRequestTO;
import com.besmartkinopoiskservice.to.response.EmptyResponseTO;
import com.besmartkinopoiskservice.to.response.movieresposes.GetMoviePageResponseTO;

public interface MovieService {
    EmptyResponseTO addMovieToDatabase(CreateMoviePageRequestTO request) throws ServiceException;

    GetMoviePageResponseTO getMoviePage(String title) throws ServiceException;

    GetMoviePageResponseTO findMoviesPages(String title, int year) throws ServiceException;
}
