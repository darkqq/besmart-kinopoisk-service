package com.besmartkinopoiskservice.service.impl;

import com.besmartkinopoiskservice.domain.MovieEntity;
import com.besmartkinopoiskservice.domain.UserEntity;
import com.besmartkinopoiskservice.exception.ServiceException;
import com.besmartkinopoiskservice.repository.MovieRepository;
import com.besmartkinopoiskservice.repository.UserRepository;
import com.besmartkinopoiskservice.service.UserService;
import com.besmartkinopoiskservice.to.domain.MovieDetailsTO;
import com.besmartkinopoiskservice.to.domain.UserDetailsTO;
import com.besmartkinopoiskservice.to.request.user.AddUserFavoriteMovieRequestTO;
import com.besmartkinopoiskservice.to.response.EmptyResponseTO;
import com.besmartkinopoiskservice.to.response.user.UserDetailsResponseTO;
import com.besmartkinopoiskservice.to.response.user.UserFavoriteMoviesListResponseTO;
import com.besmartkinopoiskservice.to.response.user.UsersListResponseTO;
import com.besmartkinopoiskservice.util.mapper.MovieMapper;
import com.besmartkinopoiskservice.util.mapper.UserMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final MovieRepository movieRepository;

    @Override
    public UsersListResponseTO getUsersList(String username) {
        List<UserEntity> users = userRepository.findAllByUsernameContaining(username);
        List<UserDetailsTO> usersDetailsList = new ArrayList<>();
        for (int i = 0; i < users.size(); i++) {
            usersDetailsList.add(UserMapper.toDto(users.get(i)));
        }
        return new UsersListResponseTO(usersDetailsList);
    }

    @Override
    public UserDetailsResponseTO getUserDetails(UUID userId) throws ServiceException{
        Optional<UserEntity> user = userRepository.findById(userId);
        if (!user.isPresent()){
            throw new ServiceException("Пользователя не существует");
        }
        return new UserDetailsResponseTO(UserMapper.toFullDto(user.get()));
    }

    @Override
    public UserFavoriteMoviesListResponseTO getUserFavoriteMovies(UUID userId) throws ServiceException {
        Optional<UserEntity> user = userRepository.findById(userId);
        if (!user.isPresent()){
            throw new ServiceException("Пользователя не существует");
        }
        List<MovieEntity> favoriteMovies = user.get().getFavoriteMovies();
        List<MovieDetailsTO> favoriteMoviesDetails = new ArrayList<>();
        for (int i = 0; i < favoriteMovies.size(); i++){
            favoriteMoviesDetails.add(MovieMapper.toDto(favoriteMovies.get(i)));
        }
        return new UserFavoriteMoviesListResponseTO(favoriteMoviesDetails);
    }

    @Override
    public EmptyResponseTO addToUserFavoriteMovies(AddUserFavoriteMovieRequestTO request) throws ServiceException {
        Optional<UserEntity> user = userRepository.findById(request.getUserId());
        if (!user.isPresent()){
            throw new ServiceException("Пользователя не существует");
        }
        Optional<MovieEntity> movie = movieRepository.findById(request.getMovieId());
        if (!movie.isPresent()){
            throw new ServiceException("Фильма не существует");
        }
        user.get().getFavoriteMovies().add(movie.get());
        movie.get().getInUserFavorite().add(user.get());
        userRepository.save(user.get());
        movieRepository.save(movie.get());
        return new EmptyResponseTO();
    }

    @Override
    public EmptyResponseTO deleteFromUserFavoriteMovies (UUID userId,UUID movieId) throws ServiceException {
        Optional<UserEntity> user = userRepository.findById(userId);
        if (!user.isPresent()){
            throw new ServiceException("Пользователя не существует");
        }
        Optional<MovieEntity> movie = movieRepository.findById(movieId);
        if (!movie.isPresent()){
            throw new ServiceException("Фильма не существует");
        }
        for (int i = 0; i < user.get().getFavoriteMovies().size(); i++){
            if (user.get().getFavoriteMovies().get(i).getId().equals(movieId)){
                user.get().getFavoriteMovies().remove(i);
            }
        }
        for (int i = 0; i < movie.get().getInUserFavorite().size(); i++){
            if (movie.get().getInUserFavorite().get(i).getId().equals(movieId)){
                movie.get().getInUserFavorite().remove(i);
            }
        }
        userRepository.save(user.get());
        movieRepository.save(movie.get());
        return new EmptyResponseTO();
    }
}
