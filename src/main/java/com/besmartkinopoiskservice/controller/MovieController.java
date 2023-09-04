package com.besmartkinopoiskservice.controller;

import lombok.RequiredArgsConstructor;
import org.apache.coyote.Request;
import org.apache.coyote.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/movie")
@RequiredArgsConstructor
public class MovieController {
    @PostMapping("/add")
    public ResponseEntity<Response> addMovie(@RequestBody Request request) {
        return ResponseEntity.ok();
    }

    @PostMapping("/delete")
    public ResponseEntity<Response> deleteMovie(@RequestBody Request request) {
        return ResponseEntity.ok();
    }

    @PostMapping("/update/title")
    public ResponseEntity<Response> updateMovieTitle(@RequestBody Request request) {
        return ResponseEntity.ok();
    }

    @PostMapping("/update/actors/add")
    public ResponseEntity<Response> addMovieActor(@RequestBody Request request) {
        return ResponseEntity.ok();
    }

    @PostMapping("/update/actors/delete")
    public ResponseEntity<Response> deleteMovieActor(@RequestBody Request request) {
        return ResponseEntity.ok();
    }

    @PostMapping("/update/directors/add")
    public ResponseEntity<Response> addMovieDirector(@RequestBody Request request) {
        return ResponseEntity.ok();
    }

    @PostMapping("/update/directors/delete")
    public ResponseEntity<Response> deleteMovieDirector(@RequestBody Request request) {
        return ResponseEntity.ok();
    }

    @PostMapping("/update/picture")
    public ResponseEntity<Response> updateMoviePicture(@RequestBody Request request) {
        return ResponseEntity.ok();
    }

    @PostMapping("/update/description")
    public ResponseEntity<Response> updateMovieDescription(@RequestBody Request request) {
        return ResponseEntity.ok();
    }

    @PostMapping("")
    public ResponseEntity<Response> getMoviePage(@RequestBody Request request) {
        return ResponseEntity.ok();
    }

    @PostMapping("/commets/")
    public ResponseEntity<Response> getMovieComments(@RequestBody Request request) {
        return ResponseEntity.ok();
    }
}
