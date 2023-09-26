package com.besmartkinopoiskservice.controller;

import com.besmartkinopoiskservice.exception.ServiceException;
import com.besmartkinopoiskservice.service.MovieService;
import com.besmartkinopoiskservice.to.request.movie.*;
import com.besmartkinopoiskservice.to.response.EmptyResponseTO;
import com.besmartkinopoiskservice.to.response.movie.MovieDetailsResponseTO;
import com.besmartkinopoiskservice.to.response.movie.MovieListResponseTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/movie")
@RequiredArgsConstructor
public class MovieController {
    private final MovieService movieService;

    //admin
    @PostMapping("/create")
    public ResponseEntity<EmptyResponseTO> createMovie(@RequestBody CreateMovieRequestTO request) throws ServiceException {
        return ResponseEntity.ok(movieService.addMovieToDatabase(request));
    }

    //admin
    @PostMapping("/delete")
    public ResponseEntity<EmptyResponseTO> deleteMovie(@RequestBody DeleteMovieRequestTO request) {
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
    @PutMapping("/update/description")
    public ResponseEntity<EmptyResponseTO> updateMovieDescription(@RequestBody UpdateMovieDescriptionRequestTO request) {
        return ResponseEntity.ok(null);
    }

    @GetMapping("/details")
    public ResponseEntity<MovieDetailsResponseTO> getMovieDetails(@RequestParam(name = "movieId", required = false) UUID movieId) throws ServiceException {
        return ResponseEntity.ok(movieService.findMovie(movieId));
    }

    @GetMapping("/list")
    public ResponseEntity<MovieListResponseTO> getMoviesList(@RequestParam(name = "movie", required = false) String movieTitle, @RequestParam(name = "year", required = false) Integer year, @RequestParam(name = "sort", required = false, defaultValue = "TIME") String sortType, @RequestParam(name = "pagesize", required = false, defaultValue = "10") int pageSize, @RequestParam(name = "offset", required = false, defaultValue = "0") int offset) throws ServiceException {
        return ResponseEntity.ok(movieService.findMoviesList(movieTitle, year, sortType, pageSize, offset));
    }
}
