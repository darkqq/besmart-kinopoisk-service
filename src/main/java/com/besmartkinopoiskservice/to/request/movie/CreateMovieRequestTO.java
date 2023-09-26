package com.besmartkinopoiskservice.to.request.movie;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.UUID;

@Data
@AllArgsConstructor
@RequiredArgsConstructor
public class CreateMovieRequestTO {
    private String title;
    private UUID imageId;
    private String description;
    private double boxOffice;
    private String premiere;
}
