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
    private final UserRepository userRepository;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;
    private final PasswordEncoder passwordEncoder;

    @Override
    public AuthenticationResponseTO registerUser(UserRegisterRequestTO request) throws ServiceException{
        if (userRepository.existsByUsername(request.getUsername())) {
            throw new ServiceException("Такой пользователь уже сущесвует");
        }

        if (userRepository.existsByEmail(request.getEmail())) {
            throw new ServiceException("Пользователь с таким email уже существует");
        }

        validationCheck(request.getUsername(), request.getPassword());

        if (!request.getPassword().equals(request.getPasswordConfirmation())){
            throw new ServiceException("Пароли не совпадают");
        }

        UserEntity user = UserEntity.builder()
                .username(request.getUsername())
                .password(passwordEncoder.encode(request.getPassword()))
                .email(request.getEmail())
                .role(Role.USER).build();

        userRepository.save(user);
        var jwtToken = jwtService.generateToken(user);

        return AuthenticationResponseTO.builder().token(jwtToken).build();
    }

    @Override
    public AuthenticationResponseTO userLogIn(UserLogInRequestTO request){
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getUsername(),
                        request.getPassword()
                )
        );
        var user = userRepository.findByUsername(request.getUsername());
        var jwtToken = jwtService.generateToken(user);
        return AuthenticationResponseTO.builder().token(jwtToken).build();
    }

    private void validationCheck(String login, String password) throws ServiceException{
        ValidationResult result = ValidationUserCredentials.checkLogin(login);
        if (!result.isSuccess()) {
            List<String> errMessages = result.getErrMesaeges();
            for (int i = 0; i < errMessages.size(); i++) {
                throw new ServiceException(errMessages.get(i));
            }
        }

        result = new ValidationUserCredentials().checkPassword(password);
        if (!result.isSuccess()) {
            List<String> errMessages = result.getErrMesaeges();
            throw new ServiceException(errMessages.get(0));
        }
    }
}
