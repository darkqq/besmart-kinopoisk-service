package com.besmartkinopoiskservice.service.impl;

import com.besmartkinopoiskservice.domain.MovieEntity;
import com.besmartkinopoiskservice.exception.ServiceException;
import com.besmartkinopoiskservice.repository.MovieRepository;
import com.besmartkinopoiskservice.service.MovieService;
import com.besmartkinopoiskservice.to.domain.MoviePageDetailsTO;
import com.besmartkinopoiskservice.to.request.movierequest.CreateMoviePageRequestTO;
import com.besmartkinopoiskservice.to.response.EmptyResponseTO;
import com.besmartkinopoiskservice.to.response.movieresposes.GetMoviePageResponseTO;
import com.besmartkinopoiskservice.util.mapper.MoviePageMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.*;

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
        movie.setPremiereYear(Integer.parseInt(premiereDatePartsString[2]));
        movie.setBoxOffice(request.getBoxOffice());
        movieRepository.save(movie);
        return new EmptyResponseTO();
    }

    @Override
    public GetMoviePageResponseTO getMoviePage(String title) throws ServiceException {
        Optional<MovieEntity> movie = movieRepository.findAllByTitle(title);
        if (movie == null) {
            throw new ServiceException("Фильмов с таким названием не существует");
        }
        List<MoviePageDetailsTO> movieDetails = new ArrayList<>();
        movieDetails.add(MoviePageMapper.toDto(movie.get()));
        return new GetMoviePageResponseTO(movieDetails);
    }

    @Override
    public GetMoviePageResponseTO findMoviesPages(String title, Integer year) throws ServiceException {
        List<MovieEntity> movie = new ArrayList<>();
        if (year != null){
            movie = movieRepository.findAllWhereYearMore(LocalDate.of(year, 1, 1));
        }
        if (title != null){
            movie.addAll(movieRepository.findAllWhereTitleLike(title));
        }
        if (movie.size() == 0 && title == null && year != null) {
            throw new ServiceException("Фильмов вышедших в этот год или позднее не существует");
        }
        else if (movie.size() == 0 && year == null && title != null) {
            throw new ServiceException("Фильмов с таким названием не существует");
        }
        else if (movie.size() == 0 && year != null && title != null){
            throw new ServiceException("Фильмов с такими параметрами не существует");
        }

        Set<MovieEntity> movieSet = new HashSet<>(movie);
        movie.clear();
        movie.addAll(movieSet);

        List<MoviePageDetailsTO> movieDetails = new ArrayList<>();
        for (int i = 0; i < movie.size(); i++){
            movieDetails.add(MoviePageMapper.toDto(movie.get(i)));
        }
            return new GetMoviePageResponseTO(movieDetails);
    }
}
