package com.besmartkinopoiskservice.service.impl;

import com.besmartkinopoiskservice.domain.MovieEntity;
import com.besmartkinopoiskservice.domain.UserEntity;
import com.besmartkinopoiskservice.exception.AuthenticationException;
import com.besmartkinopoiskservice.exception.ServiceException;
import com.besmartkinopoiskservice.repository.MovieRepository;
import com.besmartkinopoiskservice.repository.UserRepository;
import com.besmartkinopoiskservice.service.JwtService;
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
import org.springframework.data.domain.PageRequest;
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

    private final JwtService jwtService;

    @Override
    public UsersListResponseTO getUsers(String username, int pageSize, int offset) {
        PageRequest pageRequest = PageRequest.of(offset, pageSize);
        List<UserEntity> users = userRepository.findAllByUsernameContaining(username, pageRequest);
        List<UserDetailsTO> usersDetailsList = new ArrayList<>();
        for (int i = 0; i < users.size(); i++) {
            usersDetailsList.add(UserMapper.toDto(users.get(i)));
        }
        return new UsersListResponseTO(usersDetailsList);
    }

    @Override
    public UserDetailsResponseTO getUserDetails(String authorizationHeader) throws ServiceException, AuthenticationException {
        if (authorizationHeader.equals("")) {throw new AuthenticationException("Неавторизованный запрос");}
        Optional<UserEntity> user = Optional.ofNullable(userRepository.findByUsername(jwtService.extractUsername(authorizationHeader.substring(7))).orElseThrow(() -> new ServiceException("Ошибка поиска аккаунта")));
        return new UserDetailsResponseTO(UserMapper.toFullDto(user.get()));
    }

    @Override
    public UserFavoriteMoviesListResponseTO getUserFavoriteMovies(String authorizationHeader, int pageSize, int offset) throws ServiceException, AuthenticationException {
        Optional<UserEntity> user = Optional.ofNullable(userRepository.findByUsername(jwtService.extractUsername(authorizationHeader.substring(7))).orElseThrow(() -> new ServiceException("Ошибка поиска аккаунта")));
        List<MovieEntity> favoriteMovies = user.get().getFavoriteMovies();
        List<MovieDetailsTO> favoriteMoviesDetails = new ArrayList<>();
        for (int i = 1 * (offset * pageSize); i < pageSize * (offset + 1) && i < favoriteMovies.size(); i++) {
            favoriteMoviesDetails.add(MovieMapper.toDto(favoriteMovies.get(i)));
        }
        return new UserFavoriteMoviesListResponseTO(favoriteMoviesDetails);
    }

    @Override
    public EmptyResponseTO addToUserFavoriteMovies(String authorizationHeader, AddUserFavoriteMovieRequestTO request) throws ServiceException, AuthenticationException {
        Optional<UserEntity> user = Optional.ofNullable(userRepository.findByUsername(jwtService.extractUsername(authorizationHeader.substring(7))).orElseThrow(() -> new ServiceException("Ошибка поиска аккаунта")));
        Optional<MovieEntity> movie = Optional.ofNullable(movieRepository.findById(request.getMovieId()).orElseThrow(() -> new ServiceException("Фильма не существует")));
        user.get().getFavoriteMovies().add(movie.get());
        movie.get().getInUserFavorite().add(user.get());
        userRepository.save(user.get());
        movieRepository.save(movie.get());
        return new EmptyResponseTO();
    }

    @Override
    public EmptyResponseTO deleteFromUserFavoriteMovies(String authorizationHeader, UUID movieId) throws ServiceException, AuthenticationException {
        Optional<UserEntity> user = Optional.ofNullable(userRepository.findByUsername(jwtService.extractUsername(authorizationHeader.substring(7))).orElseThrow(() -> new ServiceException("Ошибка поиска аккаунта")));
        Optional<MovieEntity> movie = Optional.ofNullable(movieRepository.findById(movieId).orElseThrow(() -> new ServiceException("Фильма не существует")));
        for (int i = 0; i < user.get().getFavoriteMovies().size(); i++) {
            if (user.get().getFavoriteMovies().get(i).getId().equals(movieId)) {
                user.get().getFavoriteMovies().remove(i);
            }
        }
        for (int i = 0; i < movie.get().getInUserFavorite().size(); i++) {
            if (movie.get().getInUserFavorite().get(i).getId().equals(movieId)) {
                movie.get().getInUserFavorite().remove(i);
            }
        }
        userRepository.save(user.get());
        movieRepository.save(movie.get());
        return new EmptyResponseTO();
    }
}
