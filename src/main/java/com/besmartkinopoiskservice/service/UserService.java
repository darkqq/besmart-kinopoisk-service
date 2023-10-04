package com.besmartkinopoiskservice.service;

import com.besmartkinopoiskservice.exception.ServiceException;
import com.besmartkinopoiskservice.to.request.user.AddUserFavoriteMovieRequestTO;
import com.besmartkinopoiskservice.to.response.EmptyResponseTO;
import com.besmartkinopoiskservice.to.response.user.UserDetailsResponseTO;
import com.besmartkinopoiskservice.to.response.user.UserFavoriteMoviesListResponseTO;
import com.besmartkinopoiskservice.to.response.user.UsersListResponseTO;

import java.util.UUID;

public interface UserService {
    UsersListResponseTO getUsersList(String username);

    UserDetailsResponseTO getUserDetails(UUID userId) throws ServiceException;

    UserFavoriteMoviesListResponseTO getUserFavoriteMovies(UUID userId) throws ServiceException;

    EmptyResponseTO addToUserFavoriteMovies(String token, AddUserFavoriteMovieRequestTO request) throws ServiceException;

    EmptyResponseTO deleteFromUserFavoriteMovies(String token, UUID userId, UUID movieId) throws ServiceException;
}
