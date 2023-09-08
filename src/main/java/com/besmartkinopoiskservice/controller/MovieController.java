package com.besmartkinopoiskservice.controller;

import com.besmartkinopoiskservice.exception.ServiceException;
import com.besmartkinopoiskservice.service.MovieService;
import com.besmartkinopoiskservice.to.request.movierequest.*;
import com.besmartkinopoiskservice.to.response.EmptyResponseTO;
import com.besmartkinopoiskservice.to.response.GetCommentsResponseTO;
import com.besmartkinopoiskservice.to.response.movieresposes.GetMoviePageResponseTO;
import com.besmartkinopoiskservice.to.response.movieresposes.GetMovieResponseTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/movie")
@RequiredArgsConstructor
public class MovieController {
    private final MovieService movieService;

    //admin
    @PostMapping("/add")
    public ResponseEntity<EmptyResponseTO> addMovie(@RequestBody CreateMoviePageRequestTO request) throws ServiceException {
        return ResponseEntity.ok(movieService.addMovieToDatabase(request));
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
    @PutMapping("/update/actors/add")
    public ResponseEntity<EmptyResponseTO> addMovieActor(@RequestBody AddMovieAuthorRequestTO request) {
        return ResponseEntity.ok(null);
    }

    //admin
    @PutMapping("/update/actors/delete")
    public ResponseEntity<EmptyResponseTO> deleteMovieActor(@RequestBody DeleteMovieAuthorRequestTO request) {
        return ResponseEntity.ok(null);
    }

    //admin
    @PutMapping("/update/directors/add")
    public ResponseEntity<EmptyResponseTO> addMovieDirector(@RequestBody AddMovieAuthorRequestTO request) {
        return ResponseEntity.ok(null);
    }

    //admin
    @PutMapping("/update/directors/delete")
    public ResponseEntity<EmptyResponseTO> deleteMovieDirector(@RequestBody DeleteMovieAuthorRequestTO request) {
        return ResponseEntity.ok(null);
    }

    //admin
    @PutMapping("/update/picture")
    public ResponseEntity<EmptyResponseTO> updateMoviePicture(@RequestBody UpdateMoviePictureRequestTO request) {
        return ResponseEntity.ok(null);
    }

    //admin
    @PutMapping("/update/description")
    public ResponseEntity<EmptyResponseTO> updateMovieDescription(@RequestBody UpdateMovieDescriptionRequestTO request) {
        return ResponseEntity.ok(null);
    }

    @GetMapping("")
    public ResponseEntity<GetMoviePageResponseTO> getMoviePage(@RequestParam(name = "movie") String movieTitle) throws ServiceException {
        return ResponseEntity.ok(movieService.getMoviePage(movieTitle));
    }

    //moder, admin
    @GetMapping("/info")
    public ResponseEntity<GetMovieResponseTO> getMovieInfo(@RequestParam(name = "movie") String movieTitle) {
        return ResponseEntity.ok(null);
    }

    @GetMapping("/commets")
    public ResponseEntity<GetCommentsResponseTO> getMovieComments(@RequestParam(name = "movie") String movieTitle) {
        return ResponseEntity.ok(null);
    }
}
