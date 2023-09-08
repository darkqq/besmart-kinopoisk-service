package com.besmartkinopoiskservice.service.impl;

import com.besmartkinopoiskservice.domain.MovieEntity;
import com.besmartkinopoiskservice.exception.ServiceException;
import com.besmartkinopoiskservice.repository.MovieRepository;
import com.besmartkinopoiskservice.service.MovieService;
import com.besmartkinopoiskservice.to.request.movierequest.CreateMoviePageRequestTO;
import com.besmartkinopoiskservice.to.response.EmptyResponseTO;
import com.besmartkinopoiskservice.to.response.movieresposes.GetMoviePageResponseTO;
import com.besmartkinopoiskservice.util.mapper.MoviePageMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
@RequiredArgsConstructor
public class MovieServiceImpl implements MovieService {
    private final MovieRepository movieRepository;

    @Override
    public EmptyResponseTO addMovieToDatabase(CreateMoviePageRequestTO request) throws ServiceException {
        String[] premiereDatePartsString = request.getPremiere().split("\\.");
        LocalDate premiere = LocalDate.of(
                Integer.parseInt(premiereDatePartsString[2]),
                Integer.parseInt(premiereDatePartsString[1]),
                Integer.parseInt(premiereDatePartsString[0])
        );

        if (movieRepository.existsByTitle(request.getTitle()) && movieRepository.existsByPremiere(premiere)) {
            throw new ServiceException("Такой фильм уже существует");
        }

        MovieEntity movie = new MovieEntity();
        movie.setTitle(request.getTitle());
        movie.setDescription(request.getDescription());
        movie.setPremiere(premiere);
        movie.setBoxOffice(request.getBoxOffice());
        movieRepository.save(movie);
        return new EmptyResponseTO();
    }

    @Override
    public GetMoviePageResponseTO getMoviePage(String title) throws ServiceException{
        MovieEntity movie = movieRepository.findByTitle(title);
        if (movie == null){
            throw new ServiceException("Фильма с таким названием не существует");
        }
        return new GetMoviePageResponseTO(MoviePageMapper.toDto(movie));
    }
}
