package com.besmartkinopoiskservice.to.request.movie;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.UUID;

@Data
@AllArgsConstructor
@RequiredArgsConstructor
public class UpdateMovieDescriptionRequestTO {
    private UUID movieId;
    private String description;
}
