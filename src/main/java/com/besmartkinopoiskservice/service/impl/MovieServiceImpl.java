package com.besmartkinopoiskservice.service.impl;

import com.besmartkinopoiskservice.domain.MovieEntity;
import com.besmartkinopoiskservice.enumeration.SortType;
import com.besmartkinopoiskservice.exception.ServiceException;
import com.besmartkinopoiskservice.repository.ImageRepository;
import com.besmartkinopoiskservice.repository.MovieRepository;
import com.besmartkinopoiskservice.service.MovieService;
import com.besmartkinopoiskservice.to.domain.MovieDetailsTO;
import com.besmartkinopoiskservice.to.domain.MovieShortDetailsTO;
import com.besmartkinopoiskservice.to.request.movie.CreateMovieRequestTO;
import com.besmartkinopoiskservice.to.response.EmptyResponseTO;
import com.besmartkinopoiskservice.to.response.movie.GetMovieResponseTO;
import com.besmartkinopoiskservice.to.response.movie.GetMovieShortDetailsResponseTO;
import com.besmartkinopoiskservice.util.mapper.MovieMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.time.LocalDate;
import java.util.*;

@Service
@RequiredArgsConstructor
public class MovieServiceImpl implements MovieService {
    private final MovieRepository movieRepository;
    private final ImageRepository imageRepository;

    @Override
    public EmptyResponseTO addMovieToDatabase(CreateMovieRequestTO request) throws ServiceException {
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
    public GetMovieResponseTO findMovie(UUID movieId) throws ServiceException {
        Optional<MovieEntity> movie = movieRepository.findById(movieId);
        if (!movie.isPresent()){
            throw new ServiceException("Фильма с таким id не существует");
        }
        return new GetMovieResponseTO(MovieMapper.toDto(movie.get()));
    }

    @Override
    public GetMovieShortDetailsResponseTO findMoviesShortDetails(String title, Integer year, String sortType, int pageSize, int offset) {
        List<MovieEntity> movie = new ArrayList<>();
        if (year == null && title == null) {
            movie = movieRepository.findAll();
        } else {
            if (year != null) {
                movie = movieRepository.findAllByPremiereYearAfter(year - 1);
            }
            if (title != null) {
                movie.addAll(movieRepository.findAllByTitleContaining(title));
            }

            Set<MovieEntity> movieSet = new HashSet<>(movie);
            movie.clear();
            movie.addAll(movieSet);
        }

        if (sortType == SortType.TIME.toString()) {
            Collections.sort(movie, Comparator.comparing(MovieEntity::getPremiere));
        } else if (sortType == SortType.RATING.toString()) {
            Collections.sort(movie, Comparator.comparingDouble(MovieEntity::getCurrentRating));
        } else {
            Collections.sort(movie, Comparator.comparing(MovieEntity::getPremiere));
        }

        List<MovieEntity> movies = new ArrayList<>();
        for (int i = 0; i < pageSize && i < movie.size(); i++) {
            movies.add(movie.get(i));
        }

        List<MovieShortDetailsTO> moviesDetails = new ArrayList<>();
        for (int i = 0; i < movies.size(); i++) {
            moviesDetails.add(MovieMapper.toShortDto(movies.get(i)));
        }

        return new GetMovieShortDetailsResponseTO(moviesDetails);
    }

    @Override
    public EmptyResponseTO updateMovieImage(UUID movieId, MultipartFile image) throws ServiceException {
        Optional<MovieEntity> movie = movieRepository.findById(movieId);
        if (movie.get().getImage() != null) {
            try {
                imageRepository.saveImage(image, movie.get().getImage());
            } catch (IOException e) {
                throw new ServiceException("Ошибка при обновлении постера");
            }
        } else {
            UUID imageId = UUID.randomUUID();
            try {
                imageRepository.saveImage(image, imageId);
            } catch (IOException e) {
                throw new ServiceException("Ошибка при сохранении постера");
            }
            movie.get().setImage(imageId);
        }
        movieRepository.save(movie.get());

        return new EmptyResponseTO();
    }

    @Override
    public ResponseEntity<byte[]> getMovieImage(UUID imageId) throws ServiceException {
        byte[] imageBytes;
        try {
            imageBytes = imageRepository.getImage(imageId);
        } catch (IOException e) {
            throw new ServiceException("Проблема при получении постера фильма");
        } catch (Exception e) {
            throw new ServiceException("Постера для запрашиваемого фильма не существует");
        }

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.IMAGE_JPEG);
        headers.setContentLength(imageBytes.length);
        return new ResponseEntity<>(imageBytes, headers, HttpStatus.OK);
    }
}
