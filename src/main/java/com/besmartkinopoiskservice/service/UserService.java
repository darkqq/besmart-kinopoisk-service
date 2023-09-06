package com.besmartkinopoiskservice.service;

import com.besmartkinopoiskservice.exception.ServiceException;
import com.besmartkinopoiskservice.to.request.userrequest.UserRegisterRequestTO;
import com.besmartkinopoiskservice.to.response.userresponses.AuthenticationResponseTO;

public interface UserService {
    AuthenticationResponseTO registerUser(UserRegisterRequestTO request) throws ServiceException;
}
