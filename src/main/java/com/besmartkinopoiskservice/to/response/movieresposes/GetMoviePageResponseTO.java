package com.besmartkinopoiskservice.to.response.movieresposes;

import com.besmartkinopoiskservice.to.domain.MoviePageDetailsTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@RequiredArgsConstructor
public class GetMoviePageResponseTO {
    private MoviePageDetailsTO movieDetails;
}
