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
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.UUID;

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
    @PutMapping("/update/image")
    public ResponseEntity<EmptyResponseTO> updateMovieImage(@RequestParam("movieid") UUID movieId, @RequestParam("image") MultipartFile image) throws IOException {
        return ResponseEntity.ok(movieService.updateMovieImage(movieId, image));
    }

    //admin
    @PutMapping("/update/description")
    public ResponseEntity<EmptyResponseTO> updateMovieDescription(@RequestBody UpdateMovieDescriptionRequestTO request) {
        return ResponseEntity.ok(null);
    }

    @GetMapping("/list")
    public ResponseEntity<GetMoviePageResponseTO> getMovies(@RequestParam(name = "movie", required = false) String movieTitle, @RequestParam(name = "year", required = false) Integer year, @RequestParam(name = "sort", required = false, defaultValue = "year") String sortType, @RequestParam(name = "pagesize", required = false, defaultValue = "10") int pageSize, @RequestParam(name = "offset", required = false, defaultValue = "10") int offset) throws ServiceException, IOException {
        return ResponseEntity.ok(movieService.findMoviesPages(movieTitle, year, sortType, pageSize, offset));
    }

    @GetMapping("/image")
    public ResponseEntity<byte[]> getMovieImage(@RequestParam(name = "movieid") UUID movieId) throws ServiceException, IOException {
        return movieService.getMovieImage(movieId);
    }

    //moder, admin
    @GetMapping("/info")
    public ResponseEntity<GetMovieResponseTO> getMovieInfo(@RequestParam(name = "movie") String movieTitle, @RequestParam(name = "sort", required = false, defaultValue = "time") String sortType, @RequestParam(name = "listsize", required = false, defaultValue = "10") int commentsListSize, @RequestParam(name = "offset", required = false, defaultValue = "10") int offset) {
        return ResponseEntity.ok(null);
    }

    @GetMapping("/comments")
    public ResponseEntity<GetCommentsResponseTO> getMovieComments(@RequestParam(name = "movieid") UUID movieId) {
        return ResponseEntity.ok(null);
    }
}
