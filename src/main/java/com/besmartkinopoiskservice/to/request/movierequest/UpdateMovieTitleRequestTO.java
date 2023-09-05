package com.besmartkinopoiskservice.to.request.movierequest;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.UUID;

@Data
@AllArgsConstructor
@RequiredArgsConstructor
public class UpdateMovieTitleRequestTO {
    private UUID movieId;
    private String title;
}
