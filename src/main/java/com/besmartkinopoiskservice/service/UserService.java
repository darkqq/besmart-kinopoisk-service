package com.besmartkinopoiskservice.service;

import com.besmartkinopoiskservice.exception.ServiceException;
import com.besmartkinopoiskservice.to.response.user.UserDetailsResponseTO;
import com.besmartkinopoiskservice.to.response.user.UsersListResponseTO;

import java.util.UUID;

public interface UserService {
    UsersListResponseTO getUsersList(String username);

    UserDetailsResponseTO getUserDetails(UUID userId) throws ServiceException;
}
