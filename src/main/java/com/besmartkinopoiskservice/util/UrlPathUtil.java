package com.besmartkinopoiskservice.util;

import com.besmartkinopoiskservice.domain.RatingEntity;

import java.util.List;
import java.util.UUID;

public class UrlPathUtil {
    public static String getMovieImageRequestPath(UUID imageId){
        return "/resource/image/movie/" + imageId.toString();
    }

    public static String getAuteurImageRequestPath(UUID imageId){
        return "/resource/image/auteur/" + imageId.toString();
    }
}
