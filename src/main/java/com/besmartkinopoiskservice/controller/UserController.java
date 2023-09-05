package com.besmartkinopoiskservice.controller;

import com.besmartkinopoiskservice.to.request.*;
import com.besmartkinopoiskservice.to.response.*;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {

    @PostMapping("/register")
    public ResponseEntity<AuthenticationResponseTO> registerUser(@RequestBody UserRegisterRequestTO request) {
        return ResponseEntity.ok();
    }

    @PostMapping("/login")
    public ResponseEntity<AuthenticationResponseTO> loginUser(@RequestBody UserLogInRequestTO request) {
        return ResponseEntity.ok();
    }

    @GetMapping("")
    public ResponseEntity<GetUserPageResponseTO> getUserPage(@RequestParam(name = "username") String username) {
        return ResponseEntity.ok();
    }

    //owner, admin
    @GetMapping("/info")
    public ResponseEntity<GetUserResponseTO> getUser(@RequestParam(name = "username") String username) {
        return ResponseEntity.ok();
    }

    @GetMapping("/comments")
    public ResponseEntity<GetUserCommentsResponseTO> getUserComments(@RequestParam(name = "username") String username) {
        return ResponseEntity.ok();
    }

    //owner, moderator, admin
    @PutMapping("/comments/update")
    public ResponseEntity<EmptyResponseTO> updateUserComments(@RequestBody UpdateCommentRequestTO request) {
        return ResponseEntity.ok();
    }

    //owner, moderator, admin
    @PutMapping("/comments/delete")
    public ResponseEntity<EmptyResponseTO> deleteUserComments(@RequestBody DeleteCommentRequestTO request) {
        return ResponseEntity.ok();
    }

    @GetMapping("/favorite/")
    public ResponseEntity<GetUserFavoriteResponseTo> getUserFavorite(@RequestParam(name = "username") String username) {
        return ResponseEntity.ok();
    }

    //owner
    @PostMapping("favorite/add")
    public ResponseEntity<EmptyResponseTO> addUserFavorite(@RequestBody AddFavoriteRequestTO request) {
        return ResponseEntity.ok();
    }

    //owner, admin
    @PutMapping("/favorite/delete")
    public ResponseEntity<EmptyResponseTO> deleteUserFavorite(@RequestBody DeleteFavoriteRequestTO request) {
        return ResponseEntity.ok();
    }

}
