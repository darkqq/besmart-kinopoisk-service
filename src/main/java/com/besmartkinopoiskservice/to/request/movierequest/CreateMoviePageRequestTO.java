package com.besmartkinopoiskservice.to.request.movierequest;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@RequiredArgsConstructor
public class CreateMoviePageRequestTO {
    private String title;
    private String description;
    private double boxOffice;
    private LocalDate premiere;
}
