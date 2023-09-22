package com.besmartkinopoiskservice.service;

import com.besmartkinopoiskservice.exception.AuthenticationException;
import com.besmartkinopoiskservice.exception.ServiceException;
import com.besmartkinopoiskservice.to.request.user.UserLogInRequestTO;
import com.besmartkinopoiskservice.to.request.user.UserRegisterRequestTO;
import com.besmartkinopoiskservice.to.response.user.AuthenticationResponseTO;

public interface AuthenticationService {
    AuthenticationResponseTO registerUser(UserRegisterRequestTO request) throws ServiceException;

    AuthenticationResponseTO userLogIn(UserLogInRequestTO request) throws AuthenticationException;
}
