package com.besmartkinopoiskservice.service.impl;

import com.besmartkinopoiskservice.domain.MovieEntity;
import com.besmartkinopoiskservice.enumeration.SortType;
import com.besmartkinopoiskservice.exception.ServiceException;
import com.besmartkinopoiskservice.repository.MovieRepository;
import com.besmartkinopoiskservice.service.MovieService;
import com.besmartkinopoiskservice.to.domain.MovieDetailsTO;
import com.besmartkinopoiskservice.to.request.movie.CreateMovieRequestTO;
import com.besmartkinopoiskservice.to.response.EmptyResponseTO;
import com.besmartkinopoiskservice.to.response.movie.MovieDetailsResponseTO;
import com.besmartkinopoiskservice.to.response.movie.MovieListResponseTO;
import com.besmartkinopoiskservice.util.mapper.MovieMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.*;

@Service
@RequiredArgsConstructor
public class MovieServiceImpl implements MovieService {
    private final MovieRepository movieRepository;

    @Override
    public EmptyResponseTO addMovieToDatabase(CreateMovieRequestTO request) throws ServiceException {
        LocalDate premiere = LocalDate.parse(request.getPremiere());
        if (movieRepository.existsByTitle(request.getTitle()) && movieRepository.existsByPremiere(premiere)) {
            throw new ServiceException("Такой фильм уже существует");
        }

        MovieEntity movie = new MovieEntity();
        movie.setTitle(request.getTitle());
        movie.setImage(request.getImageId());
        movie.setDescription(request.getDescription());
        movie.setPremiere(premiere);
        movie.setPremiereYear(premiere.getYear());
        movie.setBoxOffice(request.getBoxOffice());
        movieRepository.save(movie);
        return new EmptyResponseTO();
    }

    @Override
    public MovieDetailsResponseTO findMovie(UUID movieId) throws ServiceException {
        Optional<MovieEntity> movie = movieRepository.findById(movieId);
        if (!movie.isPresent()){
            throw new ServiceException("Ошибка при поиске фильма");
        }
        return new MovieDetailsResponseTO(MovieMapper.toFullDto(movie.get()));
    }

    @Override
    public MovieListResponseTO findMoviesList(String title, Integer year, String sortType, int pageSize, int offset) throws ServiceException {
        List<MovieEntity> movies = new ArrayList<>();
        Sort sort;
        if (sortType.equals(SortType.TIME.toString())) {
            sort = Sort.by("premiere");
        } else if (sortType.equals(SortType.RATING.toString())) {
            sort = Sort.by("currentRating");
        } else {
            throw new ServiceException("Недопустимый параметр сортировки");
        }
        PageRequest pageRequest = PageRequest.of(offset, pageSize, sort);



        if (year != null && title != null){
            movies.addAll(movieRepository.findAllByTitleContainingOrPremiereYearAfter(title, year - 1, pageRequest));
        }
        else if (year != null) {
            movies = movieRepository.findAllByPremiereYearAfter(year - 1, pageRequest);
        }
        else if (title != null) {
            movies.addAll(movieRepository.findAllByTitleContaining(title, pageRequest));
        }
        else {
                movies = movieRepository.findAll(pageRequest).getContent();
        }


        List<MovieDetailsTO> moviesDetails = new ArrayList<>();
        for (int i = 0; i < movies.size(); i++) {
            moviesDetails.add(MovieMapper.toDto(movies.get(i)));
        }

        return new MovieListResponseTO(moviesDetails);
    }


}
