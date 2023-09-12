package com.besmartkinopoiskservice.util;

import com.besmartkinopoiskservice.domain.RatingEntity;

import java.util.List;

public class RatingCalculatorUtil {
    public double getAverageRating(List<RatingEntity> ratings){
        double averageRating = 0;
        for (int i = 0; i < ratings.size(); i++){
            averageRating += ratings.get(i).getRating();
        }
        averageRating = Double.parseDouble(String.format("%.2f", averageRating/ratings.size()));
        return averageRating;

    }
}
