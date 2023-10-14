package com.besmartkinopoiskservice.service;

import com.besmartkinopoiskservice.exception.AuthenticationException;
import com.besmartkinopoiskservice.exception.ServiceException;
import com.besmartkinopoiskservice.to.request.user.AddUserFavoriteMovieRequestTO;
import com.besmartkinopoiskservice.to.request.user.UpdateUserDetailsRequestTO;
import com.besmartkinopoiskservice.to.response.EmptyResponseTO;
import com.besmartkinopoiskservice.to.response.user.UserDetailsResponseTO;
import com.besmartkinopoiskservice.to.response.user.UserFavoriteMoviesListResponseTO;
import com.besmartkinopoiskservice.to.response.user.UsersListResponseTO;

import java.util.UUID;

public interface UserService {
    UsersListResponseTO getUsers(String username, int pageSize, int offset);

    UserDetailsResponseTO getUserDetails() throws ServiceException, AuthenticationException;

    UserFavoriteMoviesListResponseTO getUserFavoriteMovies(int pageSize, int offset) throws ServiceException;

    EmptyResponseTO addToUserFavoriteMovies(AddUserFavoriteMovieRequestTO request) throws ServiceException, AuthenticationException;

    EmptyResponseTO deleteFromUserFavoriteMovies(UUID movieId) throws ServiceException;

    EmptyResponseTO updateUserDetails(UpdateUserDetailsRequestTO request) throws ServiceException;
}
