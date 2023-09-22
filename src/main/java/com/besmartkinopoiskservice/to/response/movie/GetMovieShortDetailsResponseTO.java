package com.besmartkinopoiskservice.to.response.movie;

import com.besmartkinopoiskservice.to.domain.MovieShortDetailsTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@RequiredArgsConstructor
public class GetMovieShortDetailsResponseTO {
    private List<MovieShortDetailsTO> movieDetails;
}
