package com.besmartkinopoiskservice.util.mapper;

import com.besmartkinopoiskservice.domain.AuthorEntity;
import com.besmartkinopoiskservice.repository.ImageRepository;
import com.besmartkinopoiskservice.to.domain.AuteurDetailsTO;
import com.besmartkinopoiskservice.util.UrlPathUtil;

public class AuteurMapper {

    public static AuteurDetailsTO toShortDto(AuthorEntity entity){
        return new AuteurDetailsTO(
                entity.getId(),
                entity.getName(),
                UrlPathUtil.getAuteurImageRequestPath(entity.getImage())
        );
    }
}
