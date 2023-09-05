package com.besmartkinopoiskservice.controller;

import com.besmartkinopoiskservice.to.request.movierequest.*;
import com.besmartkinopoiskservice.to.response.EmptyResponseTO;
import com.besmartkinopoiskservice.to.response.GetCommentsResponseTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/movie")
@RequiredArgsConstructor
public class MovieController {
    //admin
    @PostMapping("/add")
    public ResponseEntity<EmptyResponseTO> addMovie(@RequestBody CreateMoviePageRequestTO request) {
        return ResponseEntity.ok(null);
    }

    //admin
    @PostMapping("/delete")
    public ResponseEntity<EmptyResponseTO> deleteMovie(@RequestBody DeleteMoviePageRequestTO request) {
        return ResponseEntity.ok(null);
    }

    //admin
    @PostMapping("/update/title")
    public ResponseEntity<EmptyResponseTO> updateMovieTitle(@RequestBody UpdateMovieTitleRequestTO request) {
        return ResponseEntity.ok(null);
    }

    //admin
    @PostMapping("/update/actors/add")
    public ResponseEntity<EmptyResponseTO> addMovieActor(@RequestBody AddMovieAuthorRequestTO request) {
        return ResponseEntity.ok(null);
    }

    //admin
    @PostMapping("/update/actors/delete")
    public ResponseEntity<EmptyResponseTO> deleteMovieActor(@RequestBody DeleteMovieAuthorRequestTO request) {
        return ResponseEntity.ok(null);
    }

    //admin
    @PostMapping("/update/directors/add")
    public ResponseEntity<EmptyResponseTO> addMovieDirector(@RequestBody AddMovieAuthorRequestTO request) {
        return ResponseEntity.ok(null);
    }

    //admin
    @PostMapping("/update/directors/delete")
    public ResponseEntity<EmptyResponseTO> deleteMovieDirector(@RequestBody DeleteMovieAuthorRequestTO request) {
        return ResponseEntity.ok(null);
    }

    //admin
    @PostMapping("/update/picture")
    public ResponseEntity<EmptyResponseTO> updateMoviePicture(@RequestBody UpdateMoviePictureRequestTO request) {
        return ResponseEntity.ok(null);
    }

    //admin
    @PostMapping("/update/description")
    public ResponseEntity<EmptyResponseTO> updateMovieDescription(@RequestBody UpdateMovieDescriptionRequestTO request) {
        return ResponseEntity.ok(null);
    }

    @GetMapping("")
    public ResponseEntity<GetMoviePageResponseTO> getMoviePage(@RequestBody GetMoviePageRequestTO request) {
        return ResponseEntity.ok(null);
    }

    @GetMapping("/commets")
    public ResponseEntity<GetCommentsResponseTO> getMovieComments(@RequestBody GetMovieCommentsRequestTO request) {
        return ResponseEntity.ok(null);
    }
}