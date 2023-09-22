package com.besmartkinopoiskservice.controller;

import com.besmartkinopoiskservice.to.request.auteur.*;
import com.besmartkinopoiskservice.to.response.EmptyResponseTO;
import com.besmartkinopoiskservice.to.response.GetMoviesListResponseTo;
import com.besmartkinopoiskservice.to.response.auteur.GetAuteurPageResponseTO;
import com.besmartkinopoiskservice.to.response.auteur.GetAuteurResponseTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/auteur")
@RequiredArgsConstructor
public class AuteurController {
    @PostMapping("/create")
    public ResponseEntity<EmptyResponseTO> createAuteur(@RequestBody CreateAuteurRequestTO request) {
        return ResponseEntity.ok(null);
    }

    @PostMapping("/delete")
    public ResponseEntity<EmptyResponseTO> deleteAuteur(@RequestBody DeleteAuteurRequestTO request) {
        return ResponseEntity.ok(null);
    }

    @GetMapping("")
    public ResponseEntity<GetAuteurPageResponseTO> getAuteurPage(@RequestParam(name = "id") UUID id) {
        return ResponseEntity.ok(null);
    }

    //moderator, admin
    @GetMapping("/info")
    public ResponseEntity<GetAuteurResponseTO> getAuteurInfo(@RequestParam(name = "id") UUID id) {
        return ResponseEntity.ok(null);
    }

    @PutMapping("/update/name")
    public ResponseEntity<EmptyResponseTO> updateAuteurName(@RequestBody UpdateAuteurNameRequestTO request) {
        return ResponseEntity.ok(null);
    }

    @PutMapping("/update/description")
    public ResponseEntity<EmptyResponseTO> updateAuteurDescription(@RequestBody UpdateAuteurDescriptionRequestTO request) {
        return ResponseEntity.ok(null);
    }

    @PutMapping("/update/birthday")
    public ResponseEntity<EmptyResponseTO> updateAuteurBirthday(@RequestBody UpdateAuteurBirthdayRequestTO request) {
        return ResponseEntity.ok(null);
    }

    @PutMapping("/update/photo")
    public ResponseEntity<EmptyResponseTO> updateAuteurPhoto(@RequestBody UpdateAuteurPhotoRequestTO request) {
        return ResponseEntity.ok(null);
    }

    @GetMapping("/movies")
    public ResponseEntity<GetMoviesListResponseTo> getAuteurMovies(@RequestParam(name = "name") String name) {
        return ResponseEntity.ok(null);
    }

    @PostMapping("/movies/add")
    public ResponseEntity<EmptyResponseTO> addAuteurMovies(@RequestBody UpdateAuteurMovieRequestTO request) {
        return ResponseEntity.ok(null);
    }

    @PostMapping("/movies/delete")
    public ResponseEntity<EmptyResponseTO> deleteAuteurMovies(@RequestBody UpdateAuteurMovieRequestTO request) {
        return ResponseEntity.ok(null);
    }
}
