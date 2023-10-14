package com.besmartkinopoiskservice.service.impl;

import com.besmartkinopoiskservice.domain.MovieEntity;
import com.besmartkinopoiskservice.domain.UserEntity;
import com.besmartkinopoiskservice.exception.ServiceException;
import com.besmartkinopoiskservice.repository.MovieRepository;
import com.besmartkinopoiskservice.repository.UserRepository;
import com.besmartkinopoiskservice.service.JwtService;
import com.besmartkinopoiskservice.service.UserService;
import com.besmartkinopoiskservice.to.domain.MovieDetailsTO;
import com.besmartkinopoiskservice.to.domain.UserDetailsTO;
import com.besmartkinopoiskservice.to.request.user.AddUserFavoriteMovieRequestTO;
import com.besmartkinopoiskservice.to.request.user.UpdateUserDetailsRequestTO;
import com.besmartkinopoiskservice.to.response.EmptyResponseTO;
import com.besmartkinopoiskservice.to.response.user.UserDetailsResponseTO;
import com.besmartkinopoiskservice.to.response.user.UserFavoriteMoviesListResponseTO;
import com.besmartkinopoiskservice.to.response.user.UsersListResponseTO;
import com.besmartkinopoiskservice.util.ValidationUtil;
import com.besmartkinopoiskservice.util.mapper.MovieMapper;
import com.besmartkinopoiskservice.util.mapper.UserMapper;
import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.security.core.context.SecurityContextHolder;
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


    private final EntityManager entityManager;

    private final ValidationUtil validationUtil;

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
    public UserDetailsResponseTO getUserDetails() throws ServiceException {
        Optional<UserEntity> user = Optional.ofNullable(userRepository.findByUsername(SecurityContextHolder.getContext().getAuthentication().getName()).orElseThrow(() -> new ServiceException("Ошибка поиска аккаунта")));
        return new UserDetailsResponseTO(UserMapper.toFullDto(user.get()));
    }

    @Override
    public UserFavoriteMoviesListResponseTO getUserFavoriteMovies(int pageSize, int offset) throws ServiceException {
        Optional<UserEntity> user = Optional.ofNullable(userRepository.findByUsername(SecurityContextHolder.getContext().getAuthentication().getName()).orElseThrow(() -> new ServiceException("Ошибка поиска аккаунта")));

        List<MovieEntity> favoriteMovies = user.get().getFavoriteMovies();
        List<MovieDetailsTO> favoriteMoviesDetails = new ArrayList<>();
        for (int i = 1 * (offset * pageSize); i < pageSize * (offset + 1) && i < favoriteMovies.size(); i++) {
            favoriteMoviesDetails.add(MovieMapper.toDto(favoriteMovies.get(i)));
        }
        return new UserFavoriteMoviesListResponseTO(favoriteMoviesDetails);
    }

    @Override
    public EmptyResponseTO addToUserFavoriteMovies(AddUserFavoriteMovieRequestTO request) throws ServiceException {
        Optional<UserEntity> user = Optional.ofNullable(userRepository.findByUsername(SecurityContextHolder.getContext().getAuthentication().getName()).orElseThrow(() -> new ServiceException("Ошибка поиска аккаунта")));
        MovieEntity movie = Optional.ofNullable(entityManager.getReference(MovieEntity.class, request.getMovieId())).orElseThrow(() -> new ServiceException("Фильма не существует"));

        user.get().getFavoriteMovies().add(movie);
        movie.getInUserFavorite().add(user.get());

        userRepository.save(user.get());
        movieRepository.save(movie);
        return new EmptyResponseTO();
    }

    @Override
    public EmptyResponseTO deleteFromUserFavoriteMovies(UUID movieId) throws ServiceException{
        Optional<UserEntity> user = Optional.ofNullable(userRepository.findByUsername(SecurityContextHolder.getContext().getAuthentication().getName()).orElseThrow(() -> new ServiceException("Ошибка поиска аккаунта")));
        MovieEntity movie = Optional.ofNullable(entityManager.getReference(MovieEntity.class, movieId)).orElseThrow(() -> new ServiceException("Фильма не существует"));
        for (int i = 0; i < user.get().getFavoriteMovies().size(); i++) {
            if (user.get().getFavoriteMovies().get(i).getId().equals(movieId)) {
                user.get().getFavoriteMovies().remove(i);
            }
        }
        for (int i = 0; i < movie.getInUserFavorite().size(); i++) {
            if (movie.getInUserFavorite().get(i).getId().equals(user.get().getId())) {
                movie.getInUserFavorite().remove(i);
            }
        }
        userRepository.save(user.get());
        movieRepository.save(movie);
        return new EmptyResponseTO();
    }

    @Override
    public EmptyResponseTO updateUserDetails(UpdateUserDetailsRequestTO request) throws ServiceException {
        Optional<UserEntity> user = Optional.ofNullable(userRepository.findByUsername(SecurityContextHolder.getContext().getAuthentication().getName()).orElseThrow(() -> new ServiceException("Ошибка поиска аккаунта")));
        if (!userRepository.existsByUsername(request.getUsername())){
            user.get().setUsername(request.getUsername());
        }
        else {
            throw new ServiceException("Пользователь с таким именем уже существует");
        }
        if (!userRepository.existsByEmail(request.getEmail())){
            user.get().setEmail(request.getEmail());
        }
        else {
            throw new ServiceException("Пользователь с такой электронной почтой уже существует");
        }

        validationUtil.checkCredentials(request);

        if (request.getPassword().equals(request.getPasswordConfirmation())){
            user.get().setPassword(request.getPassword());
        }
        else {
            throw new ServiceException("Пароли не совпадают");
        }
        userRepository.save(user.get());
        return new EmptyResponseTO();
    }
}
