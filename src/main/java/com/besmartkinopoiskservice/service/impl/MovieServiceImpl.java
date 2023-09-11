package com.besmartkinopoiskservice.service.impl;

import com.besmartkinopoiskservice.domain.MovieEntity;
import com.besmartkinopoiskservice.exception.ServiceException;
import com.besmartkinopoiskservice.repository.MovieRepository;
import com.besmartkinopoiskservice.service.MovieService;
import com.besmartkinopoiskservice.to.domain.MovieDetailsTO;
import com.besmartkinopoiskservice.to.domain.MoviePageDetailsTO;
import com.besmartkinopoiskservice.to.request.movierequest.CreateMoviePageRequestTO;
import com.besmartkinopoiskservice.to.response.EmptyResponseTO;
import com.besmartkinopoiskservice.to.response.movieresposes.GetMoviePageResponseTO;
import com.besmartkinopoiskservice.util.mapper.MoviePageMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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
            throw new ServiceException("Фильма с таким названием не существует");
        }
        List<MoviePageDetailsTO> movieDetails = new ArrayList<>();
        movieDetails.add(MoviePageMapper.toDto(movie.get()));
        return new GetMoviePageResponseTO(movieDetails);
    }

    @Override
    public GetMoviePageResponseTO findMoviesPages(String title, int year) throws ServiceException {
        LocalDate localYear = LocalDate.of(year, 1, 1);
        List<MovieEntity> movie = movieRepository.findAllWhereYearMore(localYear);
        if (movie == null) {
            throw new ServiceException("Фильма с таким названием не существует");
        }
        List<MoviePageDetailsTO> movieDetails = new ArrayList<>();
        for (int i = 0; i < movie.size(); i++){
            movieDetails.add(MoviePageMapper.toDto(movie.get(i)));
        }
            return new GetMoviePageResponseTO(movieDetails);
    }
}
