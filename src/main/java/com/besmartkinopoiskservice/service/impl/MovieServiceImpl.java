package com.besmartkinopoiskservice.service.impl;

import com.besmartkinopoiskservice.domain.MovieEntity;
import com.besmartkinopoiskservice.exception.ServiceException;
import com.besmartkinopoiskservice.repository.MovieRepository;
import com.besmartkinopoiskservice.repository.ImageRepository;
import com.besmartkinopoiskservice.service.MovieService;
import com.besmartkinopoiskservice.to.domain.MoviePageDetailsTO;
import com.besmartkinopoiskservice.to.request.movierequest.CreateMoviePageRequestTO;
import com.besmartkinopoiskservice.to.response.EmptyResponseTO;
import com.besmartkinopoiskservice.to.response.movieresposes.GetMoviePageResponseTO;
import com.besmartkinopoiskservice.util.mapper.MoviePageMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.time.LocalDate;
import java.util.*;

@Service
@RequiredArgsConstructor
public class MovieServiceImpl implements MovieService {
    private final MovieRepository movieRepository;
    private static final ImageRepository imageRepository = new ImageRepository();

    @Override
    public EmptyResponseTO addMovieToDatabase(CreateMoviePageRequestTO request) throws ServiceException {
        LocalDate premiere = LocalDate.parse(request.getPremiere());
        if (movieRepository.existsByTitle(request.getTitle()) && movieRepository.existsByPremiere(premiere)) {
            throw new ServiceException("Такой фильм уже существует");
        }

        MovieEntity movie = new MovieEntity();
        movie.setTitle(request.getTitle());
        movie.setDescription(request.getDescription());
        movie.setPremiere(premiere);
        movie.setPremiereYear(premiere.getYear());
        movie.setBoxOffice(request.getBoxOffice());
        movieRepository.save(movie);
        return new EmptyResponseTO();
    }

    @Override
    public GetMoviePageResponseTO getMoviePage(String title) throws ServiceException, IOException {
        Optional<MovieEntity> movie = movieRepository.findAllByTitle(title);
        if (movie == null) {
            throw new ServiceException("Фильмов с таким названием не существует");
        }
        List<MoviePageDetailsTO> movieDetails = new ArrayList<>();
        movieDetails.add(MoviePageMapper.toDto(movie.get()));
        return new GetMoviePageResponseTO(movieDetails);
    }

    @Override
    public GetMoviePageResponseTO findMoviesPages(String title, Integer year, String sortType, int pageSize, int offset) throws ServiceException, IOException {
        List<MovieEntity> movie = new ArrayList<>();
        if (year == null && title == null) {
            movie = movieRepository.findAll();
        } else {
            if (year != null) {
                movie = movieRepository.findAllByPremiereYearAfter(year);
            }
            if (title != null) {
                movie.addAll(movieRepository.findAllByTitleContaining(title));
            }
            if (movie.size() == 0 && title == null && year != null) {
                throw new ServiceException("Фильмов вышедших в этот год или позднее не существует");
            } else if (movie.size() == 0 && year == null && title != null) {
                throw new ServiceException("Фильмов с таким названием не существует");
            } else if (movie.size() == 0 && year != null && title != null) {
                throw new ServiceException("Фильмов с такими параметрами не существует");
            }

            Set<MovieEntity> movieSet = new HashSet<>(movie);
            movie.clear();
            movie.addAll(movieSet);
        }

        if (sortType == "year") {
            Collections.sort(movie, Comparator.comparing(MovieEntity::getPremiere));
        } else if (sortType == "rating") {
            Collections.sort(movie, Comparator.comparingDouble(MovieEntity::getCurrentRating));
        } else {
            Collections.sort(movie, Comparator.comparing(MovieEntity::getPremiere));
        }

        List<MovieEntity> moviesPages = new ArrayList<>();
        for (int i = 0; i < pageSize && i < movie.size(); i++) {
            moviesPages.add(movie.get(i));
        }

        List<MoviePageDetailsTO> movieDetails = new ArrayList<>();
        for (int i = 0; i < moviesPages.size(); i++) {
            movieDetails.add(MoviePageMapper.toDto(moviesPages.get(i)));
        }
        return new GetMoviePageResponseTO(movieDetails);
    }

    @Override
    public EmptyResponseTO updateMovieImage(UUID movieId, MultipartFile image) throws IOException {
        UUID imageId = UUID.randomUUID();
        imageRepository.saveImage(image, imageId);
        Optional<MovieEntity> movie = movieRepository.findById(movieId);
        movie.get().setImage(imageId);
        movieRepository.save(movie.get());

        return new EmptyResponseTO();
    }
}
