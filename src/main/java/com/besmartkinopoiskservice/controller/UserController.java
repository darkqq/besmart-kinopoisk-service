package com.besmartkinopoiskservice.controller;

import com.besmartkinopoiskservice.exception.ServiceException;
import com.besmartkinopoiskservice.service.UserService;
import com.besmartkinopoiskservice.to.request.user.*;
import com.besmartkinopoiskservice.to.response.*;
import com.besmartkinopoiskservice.to.response.user.*;
import lombok.RequiredArgsConstructor;
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
    public ResponseEntity<GetMoviesListResponseTo> getUserFavorite(@RequestParam(name = "username") String username) {
        return ResponseEntity.ok(null);
    }

    //owner
    @PostMapping("/favorite/add")
    public ResponseEntity<EmptyResponseTO> addUserFavorite(@RequestBody AddFavoriteRequestTO request) {
        return ResponseEntity.ok(null);
    }

    //owner, admin
    @DeleteMapping("/favorite/delete")
    public ResponseEntity<EmptyResponseTO> deleteUserFavorite(@RequestParam(name = "movieid") UUID movieId) {
        return ResponseEntity.ok(null);
    }
}