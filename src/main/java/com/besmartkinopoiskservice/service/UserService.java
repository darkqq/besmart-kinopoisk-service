package com.besmartkinopoiskservice.service;

import com.besmartkinopoiskservice.exception.AuthenticationException;
import com.besmartkinopoiskservice.exception.ServiceException;
import com.besmartkinopoiskservice.to.request.user.AddUserFavoriteMovieRequestTO;
import com.besmartkinopoiskservice.to.response.EmptyResponseTO;
import com.besmartkinopoiskservice.to.response.user.UserDetailsResponseTO;
import com.besmartkinopoiskservice.to.response.user.UserFavoriteMoviesListResponseTO;
import com.besmartkinopoiskservice.to.response.user.UsersListResponseTO;

import java.util.UUID;

public interface UserService {
    UsersListResponseTO getUsers(String username, int pageSize, int offset);

    UserDetailsResponseTO getUserDetails(String authorizationHeader) throws ServiceException, AuthenticationException;

    UserFavoriteMoviesListResponseTO getUserFavoriteMovies(String authorizationHeader, int pageSize, int offset) throws ServiceException, AuthenticationException;

    EmptyResponseTO addToUserFavoriteMovies(String token, AddUserFavoriteMovieRequestTO request) throws ServiceException, AuthenticationException;

    EmptyResponseTO deleteFromUserFavoriteMovies(String token, UUID movieId) throws ServiceException, AuthenticationException;
}
