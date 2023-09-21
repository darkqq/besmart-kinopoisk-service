package com.besmartkinopoiskservice.to.domain;

import com.besmartkinopoiskservice.domain.MovieEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@RequiredArgsConstructor
public class UserDetailsTO {
    private String username;
    private List<MovieEntity> favoriteMovies;
}
