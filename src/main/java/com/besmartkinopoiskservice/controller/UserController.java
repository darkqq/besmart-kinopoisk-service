package com.besmartkinopoiskservice.controller;

import lombok.RequiredArgsConstructor;
import org.apache.coyote.Request;
import org.apache.coyote.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {

    @PostMapping("/register")
    public ResponseEntity<Response> registerUser(@RequestBody Request request) {
        return ResponseEntity.ok();

    }

    @PostMapping("/login")
    public ResponseEntity<Response> loginUser(@RequestBody Request request) {
        return ResponseEntity.ok();
    }

    @GetMapping("")
    public ResponseEntity<Response> getUserPage(@RequestBody Request request) {
        return ResponseEntity.ok();
    }

    @GetMapping("/comments/")
    public ResponseEntity<Response> getUserComments(@RequestBody Request request) {
        return ResponseEntity.ok();
    }

    @PutMapping("/comments/update")
    public ResponseEntity<Response> updateUserComments(@RequestBody Request request) {
        return ResponseEntity.ok();
    }

    @PutMapping("/comments/delete")
    public ResponseEntity<Response> deleteUserComments(@RequestBody Request request) {
        return ResponseEntity.ok();
    }

    @GetMapping("/favorite/")
    public ResponseEntity<Response> getUserFavorite(@RequestBody Request request) {
        return ResponseEntity.ok();
    }

    @PutMapping("favorite/add")
    public ResponseEntity<Response> addUserFavorite(@RequestBody Request request) {
        return ResponseEntity.ok();
    }

    @PutMapping("/favorite/delete")
    public ResponseEntity<Response> deleteUserFavorite(@RequestBody Request request) {
        return ResponseEntity.ok();
    }

}
