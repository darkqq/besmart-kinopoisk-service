package com.besmartkinopoiskservice.to.request.movie;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.UUID;

@Data
@AllArgsConstructor
@RequiredArgsConstructor
public class DeleteMovieRequestTO {
    private UUID movieId;
}
