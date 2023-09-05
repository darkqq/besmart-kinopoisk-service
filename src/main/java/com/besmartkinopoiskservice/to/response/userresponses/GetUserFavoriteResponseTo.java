package com.besmartkinopoiskservice.to.response.userresponses;

import com.besmartkinopoiskservice.to.domain.MovieDetailsTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@RequiredArgsConstructor
public class GetUserFavoriteResponseTo {
    private List<MovieDetailsTO> favoriteMovies;
}