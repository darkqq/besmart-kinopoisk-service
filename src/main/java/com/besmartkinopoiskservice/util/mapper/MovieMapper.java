package com.besmartkinopoiskservice.util.mapper;

import com.besmartkinopoiskservice.domain.AuthorEntity;
import com.besmartkinopoiskservice.domain.MovieEntity;
import com.besmartkinopoiskservice.to.domain.AuteurShortDetailsTO;
import com.besmartkinopoiskservice.to.domain.MovieDetailsTO;
import com.besmartkinopoiskservice.to.domain.MovieShortDetailsTO;
import com.besmartkinopoiskservice.util.RatingCalculatorUtil;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MovieMapper {

    public static MovieDetailsTO toDto(MovieEntity entity) {

        return new MovieDetailsTO(
                entity.getId(),
                entity.getImage(),
                entity.getTitle(),
                new RatingCalculatorUtil().getAverageRating(entity.getRating()),
                entity.getDescription(),
                entity.getBoxOffice(),
                entity.getPremiere(),
                getAuteursShortDetailsList(entity.getActors()),
                getAuteursShortDetailsList(entity.getDirectors())
        );
    }

    public static MovieShortDetailsTO toShortDto(MovieEntity entity) {
        return new MovieShortDetailsTO(
                entity.getId(),
                entity.getImage(),
                entity.getTitle(),
                new RatingCalculatorUtil().getAverageRating(entity.getRating()),
                entity.getPremiere()
        );
    }

    private static List<AuteurShortDetailsTO> getAuteursShortDetailsList(List<AuthorEntity> entities) {
        List<AuteurShortDetailsTO> auteurShortDetails = new ArrayList<>();
        for (int i = 0; i < entities.size(); i++) {
            auteurShortDetails.add(AuteurMapper.toShortDto(entities.get(i)));
        }
        return auteurShortDetails;
    }
}
