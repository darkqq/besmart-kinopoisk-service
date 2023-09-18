package com.besmartkinopoiskservice.controller;

import com.besmartkinopoiskservice.service.UserService;
import com.besmartkinopoiskservice.to.request.userrequest.*;
import com.besmartkinopoiskservice.to.response.*;
import com.besmartkinopoiskservice.to.response.userresponses.*;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @GetMapping("")
    public ResponseEntity<GetUserResponseTO> getUserPage(@RequestParam(name = "username") String username) {
        return ResponseEntity.ok(null);
    }

    //owner, admin
    @GetMapping("/info")
    public ResponseEntity<GetUserShortInfoResponseTO> getUserInfo(@RequestParam(name = "username") String username) {
        return ResponseEntity.ok(null);
    }

    @GetMapping("/favorites")
    public ResponseEntity<GetMoviesListResponseTo> getUserFavorite(@RequestParam(name = "username") String username) {
        return ResponseEntity.ok(null);
    }

    //owner
    @PostMapping("favorite/add")
    public ResponseEntity<EmptyResponseTO> addUserFavorite(@RequestBody AddFavoriteRequestTO request) {
        return ResponseEntity.ok(null);
    }

    //owner, admin
    @PutMapping("/favorite/delete")
    public ResponseEntity<EmptyResponseTO> deleteUserFavorite(@RequestParam(name = "movieid") UUID movieId) {
        return ResponseEntity.ok(null);
    }
}