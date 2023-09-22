package com.besmartkinopoiskservice.controller;

import com.besmartkinopoiskservice.exception.ServiceException;
import com.besmartkinopoiskservice.service.MovieService;
import com.besmartkinopoiskservice.to.request.movie.*;
import com.besmartkinopoiskservice.to.response.EmptyResponseTO;
import com.besmartkinopoiskservice.to.response.movie.GetMovieResponseTO;
import com.besmartkinopoiskservice.to.response.movie.GetMovieShortInfoResponseTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
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

    @PutMapping("/update/image")
    public ResponseEntity<EmptyResponseTO> updateMovieImage(@RequestParam("movieid") UUID movieId, @RequestParam("image") MultipartFile image) throws ServiceException {
        return ResponseEntity.ok(movieService.updateMovieImage(movieId, image));
    }

    //admin
    @PutMapping("/update/description")
    public ResponseEntity<EmptyResponseTO> updateMovieDescription(@RequestBody UpdateMovieDescriptionRequestTO request) {
        return ResponseEntity.ok(null);
    }

    @GetMapping("/list")
    public ResponseEntity<GetMovieResponseTO> getMovies(@RequestParam(name = "movie", required = false) String movieTitle, @RequestParam(name = "year", required = false) Integer year, @RequestParam(name = "sort", required = false, defaultValue = "TIME") String sortType, @RequestParam(name = "pagesize", required = false, defaultValue = "10") int pageSize, @RequestParam(name = "offset", required = false, defaultValue = "10") int offset) throws ServiceException, IOException {
        return ResponseEntity.ok(movieService.findMovies(movieTitle, year, sortType, pageSize, offset));
    }

    //admin
    @GetMapping("/image")
    public ResponseEntity<byte[]> getMovieImage(@RequestParam(name = "movieid") UUID movieId) throws ServiceException, IOException {
        return movieService.getMovieImage(movieId);
    }

    //moder, admin
    @GetMapping("/info")
    public ResponseEntity<GetMovieShortInfoResponseTO> getMovieInfo(@RequestParam(name = "movie") String movieTitle, @RequestParam(name = "sort", required = false, defaultValue = "TIME") String sortType, @RequestParam(name = "listsize", required = false, defaultValue = "10") int commentsListSize, @RequestParam(name = "offset", required = false, defaultValue = "10") int offset) {
        return ResponseEntity.ok(null);
    }
}
