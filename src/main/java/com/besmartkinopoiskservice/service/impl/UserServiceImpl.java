package com.besmartkinopoiskservice.service.impl;

import com.besmartkinopoiskservice.domain.UserEntity;
import com.besmartkinopoiskservice.enumeration.Role;
import com.besmartkinopoiskservice.exception.ServiceException;
import com.besmartkinopoiskservice.repository.UserRepository;
import com.besmartkinopoiskservice.service.JwtService;
import com.besmartkinopoiskservice.service.UserService;
import com.besmartkinopoiskservice.to.request.userrequest.UserLogInRequestTO;
import com.besmartkinopoiskservice.to.request.userrequest.UserRegisterRequestTO;
import com.besmartkinopoiskservice.to.response.EmptyResponseTO;
import com.besmartkinopoiskservice.to.response.userresponses.AuthenticationResponseTO;
import com.besmartkinopoiskservice.util.ValidationResult;
import com.besmartkinopoiskservice.util.ValidationUserCredentials;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

}
