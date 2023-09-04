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
    public ResponseEntity<Response> registerUser(@RequestBody Request request){
        return ResponseEntity.ok();
    }

    @PostMapping("/login")
    public ResponseEntity<Response> registerUser(@RequestBody Request request){
        return ResponseEntity.ok();
    }

    @GetMapping("/page")
    public ResponseEntity<Response> getUserPage(@RequestBody Request request){
        return ResponseEntity.ok();
    }

    @GetMapping("/favorite")
    public ResponseEntity<Response> getUserFavorite(@RequestBody Request request){
        return ResponseEntity.ok();
    }

    @GetMapping("/comments")
    public ResponseEntity<Response> getUserComments(@RequestBody Request request){
        return ResponseEntity.ok();
    }

}
