package com.besmartkinopoiskservice.util.mapper;

import com.besmartkinopoiskservice.domain.MovieEntity;
import com.besmartkinopoiskservice.to.domain.CommentDetailsTO;
import com.besmartkinopoiskservice.to.domain.MoviePageDetailsTO;
import com.besmartkinopoiskservice.util.RatingCalculatorUtil;

import java.util.List;

public class MoviePageMapper {
    public static MoviePageDetailsTO toDto (MovieEntity entity){
        List<CommentDetailsTO> commentDetails = entity.getComments().stream().map(CommentMapper::toDto).toList();

        return new MoviePageDetailsTO(
                entity.getImage(),
                entity.getTitle(),
                new RatingCalculatorUtil().getAverageRating(entity.getRating()),
                entity.getDescription(),
                entity.getBoxOffice(),
                entity.getPremiere(),
                commentDetails
        );
    }
}
