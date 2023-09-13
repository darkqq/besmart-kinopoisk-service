package com.besmartkinopoiskservice.service;

import com.besmartkinopoiskservice.exception.ServiceException;
import com.besmartkinopoiskservice.to.request.movierequest.CreateMoviePageRequestTO;
import com.besmartkinopoiskservice.to.response.EmptyResponseTO;
import com.besmartkinopoiskservice.to.response.movieresposes.GetMoviePageResponseTO;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.UUID;

public interface MovieService {
    EmptyResponseTO addMovieToDatabase(CreateMoviePageRequestTO request) throws ServiceException;

    GetMoviePageResponseTO getMoviePage(String title) throws ServiceException, IOException;

    GetMoviePageResponseTO findMoviesPages(String title, Integer year, String sortType, int pageSize, int offset) throws ServiceException, IOException;

    EmptyResponseTO updateMovieImage(UUID movieId, MultipartFile image) throws IOException;
}
