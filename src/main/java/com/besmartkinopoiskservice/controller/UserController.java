package com.besmartkinopoiskservice.controller;

import com.besmartkinopoiskservice.exception.AuthenticationException;
import com.besmartkinopoiskservice.exception.ServiceException;
import com.besmartkinopoiskservice.service.UserService;
import com.besmartkinopoiskservice.to.request.user.*;
import com.besmartkinopoiskservice.to.response.*;
import com.besmartkinopoiskservice.to.response.user.*;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @GetMapping("/list")
    public ResponseEntity<UsersListResponseTO> getUsersList(@RequestParam(name = "username") String username, @RequestParam(name = "pagesize", required = false, defaultValue = "10") int pageSize, @RequestParam(name = "offset", required = false, defaultValue = "0") int offset) {
        return ResponseEntity.ok(userService.getUsers(username, pageSize, offset));
    }

    @GetMapping("/details")
    public ResponseEntity<UserDetailsResponseTO> getUserDetails(@RequestHeader(value = HttpHeaders.AUTHORIZATION, defaultValue = "") String authorizationHeader) throws ServiceException, AuthenticationException {
        return ResponseEntity.ok(userService.getUserDetails(authorizationHeader));
    }

    @GetMapping("/favorites")
    public ResponseEntity<UserFavoriteMoviesListResponseTO> getUserFavorite(@RequestHeader(value = HttpHeaders.AUTHORIZATION, defaultValue = "") String authorizationHeader, @RequestParam(name = "pagesize", required = false, defaultValue = "10") int pageSize, @RequestParam(name = "offset", required = false, defaultValue = "0") int offset) throws ServiceException, AuthenticationException {
        return ResponseEntity.ok(userService.getUserFavoriteMovies(authorizationHeader, pageSize, offset));
    }

    //owner
    @PutMapping("/favorite")
    public ResponseEntity<EmptyResponseTO> addUserFavorite(@RequestHeader(value = HttpHeaders.AUTHORIZATION, defaultValue = "") String authorizationHeader, @RequestBody AddUserFavoriteMovieRequestTO request) throws ServiceException, AuthenticationException {
        return ResponseEntity.ok(userService.addToUserFavoriteMovies(authorizationHeader, request));
    }

    //owner, admin
    @DeleteMapping("/favorite")
    public ResponseEntity<EmptyResponseTO> deleteUserFavorite(@RequestHeader(value = HttpHeaders.AUTHORIZATION, defaultValue = "") String authorizationHeader, @RequestParam(name = "movieid") UUID movieId) throws ServiceException, AuthenticationException {
        return ResponseEntity.ok(userService.deleteFromUserFavoriteMovies(authorizationHeader, movieId));
    }
}