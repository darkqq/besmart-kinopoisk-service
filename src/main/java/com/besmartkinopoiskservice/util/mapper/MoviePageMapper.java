package com.besmartkinopoiskservice.util.mapper;

import com.besmartkinopoiskservice.domain.MovieEntity;
import com.besmartkinopoiskservice.to.domain.CommentDetailsTO;
import com.besmartkinopoiskservice.to.domain.MoviePageDetailsTO;
import com.besmartkinopoiskservice.util.GetAverageRating;
import lombok.RequiredArgsConstructor;

import java.util.ArrayList;
import java.util.List;

public class MoviePageMapper {
    public static MoviePageDetailsTO toDto (MovieEntity entity){
        List<CommentDetailsTO> commentDetails = new ArrayList<>();
        for (int i = 0; i < entity.getComments().size(); i++){
            commentDetails.add(new CommentMapper().toDto(entity.getComments().get(i)));
        }

        return new MoviePageDetailsTO(
                entity.getImage(),
                entity.getTitle(),
                new GetAverageRating().getAverageRating(entity.getRating()),
                entity.getDescription(),
                entity.getBoxOffice(),
                entity.getPremiere(),
                commentDetails
        );
    }
}
