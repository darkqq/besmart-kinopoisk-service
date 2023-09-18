package com.besmartkinopoiskservice.to.response.movieresposes;

import com.besmartkinopoiskservice.to.domain.MovieDetailsTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@AllArgsConstructor
@RequiredArgsConstructor
public class GetMovieShortInfoResponseTO {
    private MovieDetailsTO movieDetails;
}
