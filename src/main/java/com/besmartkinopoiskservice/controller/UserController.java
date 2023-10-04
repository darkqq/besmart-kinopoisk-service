package com.besmartkinopoiskservice.controller;

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
    public ResponseEntity<UsersListResponseTO> getUsersList(@RequestParam(name = "username") String username) {
        return ResponseEntity.ok(userService.getUsersList(username));
    }

    @GetMapping("/details")
    public ResponseEntity<UserDetailsResponseTO> getUserDetails(@RequestParam(name = "userid") UUID userId) throws ServiceException {
        return ResponseEntity.ok(userService.getUserDetails(userId));
    }

    @GetMapping("/favorites")
    public ResponseEntity<UserFavoriteMoviesListResponseTO> getUserFavorite(@RequestParam(name = "userid") UUID userId) throws ServiceException {
        return ResponseEntity.ok(userService.getUserFavoriteMovies(userId));
    }

    //owner
    @PostMapping("/favorite/add")
    public ResponseEntity<EmptyResponseTO> addUserFavorite(@RequestHeader(value = HttpHeaders.AUTHORIZATION, defaultValue = "") String authorizationHeader, @RequestBody AddUserFavoriteMovieRequestTO request) throws ServiceException {
        return ResponseEntity.ok(userService.addToUserFavoriteMovies(authorizationHeader, request));
    }

    //owner, admin
    @DeleteMapping("/favorite/delete")
    public ResponseEntity<EmptyResponseTO> deleteUserFavorite(@RequestHeader(value = HttpHeaders.AUTHORIZATION, defaultValue = "") String authorizationHeader, @RequestParam(name = "userid") UUID userId, @RequestParam(name = "movieid") UUID movieId) throws ServiceException {
        return ResponseEntity.ok(userService.deleteFromUserFavoriteMovies(authorizationHeader, userId, movieId));
    }
}