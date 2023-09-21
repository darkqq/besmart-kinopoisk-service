package com.besmartkinopoiskservice.to.request.movie;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@AllArgsConstructor
@RequiredArgsConstructor
public class CreateMovieRequestTO {
    private String title;
    private String description;
    private double boxOffice;
    private String premiere;
}
