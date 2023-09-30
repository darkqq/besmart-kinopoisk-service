package com.besmartkinopoiskservice.util.mapper;

import com.besmartkinopoiskservice.domain.AuthorEntity;
import com.besmartkinopoiskservice.domain.MovieEntity;
import com.besmartkinopoiskservice.to.domain.AuteurDetailsTO;
import com.besmartkinopoiskservice.to.domain.MovieFullDetailsTO;
import com.besmartkinopoiskservice.to.domain.MovieDetailsTO;
import com.besmartkinopoiskservice.util.RatingCalculatorUtil;
import com.besmartkinopoiskservice.util.UrlPathUtil;

import java.util.ArrayList;
import java.util.List;

public class MovieMapper {


    public static MovieFullDetailsTO toDto(MovieEntity entity) {

        return new MovieFullDetailsTO(
                entity.getId(),
                UrlPathUtil.getMovieImageRequestPath(entity.getImage()),
                entity.getTitle(),
                RatingCalculatorUtil.getAverageRating(entity.getRating()),
                entity.getDescription(),
                entity.getBoxOffice(),
                entity.getPremiere(),
                getAuteursShortDetailsList(entity.getActors()),
                getAuteursShortDetailsList(entity.getDirectors())
        );
    }

    public static MovieDetailsTO toShortDto(MovieEntity entity) {
        return new MovieDetailsTO(
                entity.getId(),
                UrlPathUtil.getMovieImageRequestPath(entity.getImage()),
                entity.getTitle(),
                RatingCalculatorUtil.getAverageRating(entity.getRating()),
                entity.getPremiere()
        );
    }

    private static List<AuteurDetailsTO> getAuteursShortDetailsList(List<AuthorEntity> entities) {
        List<AuteurDetailsTO> auteurShortDetails = new ArrayList<>();
        for (int i = 0; i < entities.size(); i++) {
            auteurShortDetails.add(AuteurMapper.toShortDto(entities.get(i)));
        }
        return auteurShortDetails;
    }
}
