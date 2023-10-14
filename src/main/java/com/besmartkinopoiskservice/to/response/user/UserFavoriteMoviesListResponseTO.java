package com.besmartkinopoiskservice.to.response.user;

import com.besmartkinopoiskservice.to.domain.MovieDetailsTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@RequiredArgsConstructor
public class UserFavoriteMoviesListResponseTO {
    private List<MovieDetailsTO> favoriteMoviesList;
}
