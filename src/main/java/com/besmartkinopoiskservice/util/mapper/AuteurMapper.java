package com.besmartkinopoiskservice.util.mapper;

import com.besmartkinopoiskservice.domain.AuthorEntity;
import com.besmartkinopoiskservice.to.domain.AuteurShortDetailsTO;

public class AuteurMapper {
    public static AuteurShortDetailsTO toShortDto(AuthorEntity entity){
        return new AuteurShortDetailsTO(
                entity.getId(),
                entity.getName(),
                entity.getImage()
        );
    }
}
