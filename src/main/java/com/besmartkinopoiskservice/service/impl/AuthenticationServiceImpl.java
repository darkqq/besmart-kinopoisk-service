package com.besmartkinopoiskservice.service.impl;

import com.besmartkinopoiskservice.domain.UserEntity;
import com.besmartkinopoiskservice.enumeration.Role;
import com.besmartkinopoiskservice.exception.AuthenticationException;
import com.besmartkinopoiskservice.exception.ServiceException;
import com.besmartkinopoiskservice.repository.UserRepository;
import com.besmartkinopoiskservice.service.AuthenticationService;
import com.besmartkinopoiskservice.service.JwtService;
import com.besmartkinopoiskservice.to.request.user.UserLogInRequestTO;
import com.besmartkinopoiskservice.to.request.user.UserRegisterRequestTO;
import com.besmartkinopoiskservice.to.response.user.AuthenticationResponseTO;
import com.besmartkinopoiskservice.util.ValidationUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AuthenticationServiceImpl implements AuthenticationService {
    private final UserRepository userRepository;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;
    private final PasswordEncoder passwordEncoder;

    private final ValidationUtil validationUserCredentials;

    @Override
    public AuthenticationResponseTO registerUser(UserRegisterRequestTO request) throws ServiceException {
        if (userRepository.existsByUsername(request.getUsername())) {
            throw new ServiceException("Такой пользователь уже существует");
        }

        if (userRepository.existsByEmail(request.getEmail())) {
            throw new ServiceException("Пользователь с таким email уже существует");
        }

        validationUserCredentials.checkCredentials(request);

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
    public AuthenticationResponseTO userLogIn(UserLogInRequestTO request) throws AuthenticationException {
        Optional<UserEntity> user = userRepository.findByUsername(request.getUsername());
        if (!user.isPresent()){
            throw new AuthenticationException("Пользователя с таким именем не существует");
        }
        else if (!BCrypt.checkpw(request.getPassword(), user.get().getPassword())){
            throw new AuthenticationException("Вы ввели неверный пароль");
        }
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getUsername(),
                        request.getPassword()
                )
        );
        var jwtToken = jwtService.generateToken(user.get());
        return AuthenticationResponseTO.builder().token(jwtToken).build();
    }
}
