package com.besmartkinopoiskservice.controller;

import com.besmartkinopoiskservice.to.request.userrequest.*;
import com.besmartkinopoiskservice.to.response.*;
import com.besmartkinopoiskservice.to.response.userresponses.*;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {

    @PostMapping("/register")
    public ResponseEntity<AuthenticationResponseTO> registerUser(@RequestBody UserRegisterRequestTO request) {
        return ResponseEntity.ok(null);
    }

    @PostMapping("/login")
    public ResponseEntity<AuthenticationResponseTO> loginUser(@RequestBody UserLogInRequestTO request) {
        return ResponseEntity.ok(null);
    }

    @GetMapping("")
    public ResponseEntity<GetUserPageResponseTO> getUserPage(@RequestParam(name = "username") String username) {
        return ResponseEntity.ok(null);
    }

    //owner, admin
    @GetMapping("/info")
    public ResponseEntity<GetUserResponseTO> getUserInfo(@RequestParam(name = "username") String username) {
        return ResponseEntity.ok(null);
    }

    @GetMapping("/comments")
    public ResponseEntity<GetCommentsResponseTO> getUserComments(@RequestParam(name = "username") String username) {
        return ResponseEntity.ok(null);
    }

    //owner, moderator, admin
    @PutMapping("/comments/update")
    public ResponseEntity<EmptyResponseTO> updateUserComments(@RequestBody UpdateCommentRequestTO request) {
        return ResponseEntity.ok(null);
    }

    //owner, moderator, admin
    @PutMapping("/comments/delete")
    public ResponseEntity<EmptyResponseTO> deleteUserComments(@RequestBody DeleteCommentRequestTO request) {
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
    public ResponseEntity<EmptyResponseTO> deleteUserFavorite(@RequestBody DeleteFavoriteRequestTO request) {
        return ResponseEntity.ok(null);
    }

}