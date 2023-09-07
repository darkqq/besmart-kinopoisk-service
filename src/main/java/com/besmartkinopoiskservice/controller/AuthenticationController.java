package com.besmartkinopoiskservice.controller;

import com.besmartkinopoiskservice.exception.ServiceException;
import com.besmartkinopoiskservice.service.AuthenticationService;
import com.besmartkinopoiskservice.service.UserService;
import com.besmartkinopoiskservice.to.request.userrequest.UserLogInRequestTO;
import com.besmartkinopoiskservice.to.request.userrequest.UserRegisterRequestTO;
import com.besmartkinopoiskservice.to.response.userresponses.AuthenticationResponseTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthenticationController {
    private final AuthenticationService authService;

    @PostMapping("/register")
    public ResponseEntity<AuthenticationResponseTO> registerUser(@RequestBody UserRegisterRequestTO request) throws ServiceException {
        return ResponseEntity.ok(authService.registerUser(request));
    }

    @PostMapping("/login")
    public ResponseEntity<AuthenticationResponseTO> loginUser(@RequestBody UserLogInRequestTO request) {
        return ResponseEntity.ok(authService.userLogIn(request));
    }
}
