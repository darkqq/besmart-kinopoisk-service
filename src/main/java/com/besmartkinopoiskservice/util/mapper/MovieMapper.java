package com.besmartkinopoiskservice.util.mapper;

import com.besmartkinopoiskservice.domain.MovieEntity;
import com.besmartkinopoiskservice.to.domain.MovieDetailsTO;
import com.besmartkinopoiskservice.util.RatingCalculatorUtil;

public class MovieMapper {
    public static MovieDetailsTO toDto (MovieEntity entity){

        return new MovieDetailsTO(
                entity.getId(),
                entity.getImage(),
                entity.getTitle(),
                new RatingCalculatorUtil().getAverageRating(entity.getRating()),
                entity.getDescription(),
                entity.getBoxOffice(),
                entity.getPremiere()
        );
    }
}
