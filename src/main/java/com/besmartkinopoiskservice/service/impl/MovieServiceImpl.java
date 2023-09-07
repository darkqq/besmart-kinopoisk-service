package com.besmartkinopoiskservice.service.impl;

import com.besmartkinopoiskservice.domain.MovieEntity;
import com.besmartkinopoiskservice.exception.ServiceException;
import com.besmartkinopoiskservice.repository.MovieRepository;
import com.besmartkinopoiskservice.service.MovieService;
import com.besmartkinopoiskservice.to.request.movierequest.CreateMoviePageRequestTO;
import com.besmartkinopoiskservice.to.response.EmptyResponseTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MovieServiceImpl implements MovieService {
    private MovieRepository movieRepository;

    @Override
    public EmptyResponseTO addMovieToDatabase(CreateMoviePageRequestTO request) throws ServiceException {
        if (movieRepository.existsByTitle(request.getTitle()) && movieRepository.existsByPremiere(request.getPremiere())) {
            throw new ServiceException("Такой фильм уже существует");
        }

        MovieEntity movie = new MovieEntity();
        movie.setTitle(request.getTitle());
        movie.setDescription(request.getDescription());
        movie.setPremiere(request.getPremiere());
        movie.setBoxOffice(request.getBoxOffice());
        movieRepository.save(movie);
        return new EmptyResponseTO();
    }
}
