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
@RequestMapping("/auteur")
@RequiredArgsConstructor
public class AuteurController {
    @PostMapping("/add")
    public ResponseEntity<Response> addAuteur(@RequestBody Request request) {
        return ResponseEntity.ok(null);
    }

    @PostMapping("/delete")
    public ResponseEntity<Response> deleteAuteur(@RequestBody Request request) {
        return ResponseEntity.ok(null);
    }

    @PostMapping("")
    public ResponseEntity<Response> getAuteur(@RequestBody Request request) {
        return ResponseEntity.ok(null);
    }

    @PostMapping("/update/name")
    public ResponseEntity<Response> updateAuteurName(@RequestBody Request request) {
        return ResponseEntity.ok(null);
    }

    @PostMapping("/update/description")
    public ResponseEntity<Response> updateAuteurDescription(@RequestBody Request request) {
        return ResponseEntity.ok(null);
    }

    @PostMapping("/update/birthday")
    public ResponseEntity<Response> updateAuteurBirthday(@RequestBody Request request) {
        return ResponseEntity.ok(null);
    }

    @PostMapping("/update/photo")
    public ResponseEntity<Response> updateAuteurPhoto(@RequestBody Request request) {
        return ResponseEntity.ok(null);
    }

    @PostMapping("/movies")
    public ResponseEntity<Response> addAuteurMovies(@RequestBody Request request) {
        return ResponseEntity.ok(null);
    }
}
