package com.besmartkinopoiskservice.util.mapper;

import com.besmartkinopoiskservice.domain.UserEntity;
import com.besmartkinopoiskservice.to.domain.UserDetailsTO;
import com.besmartkinopoiskservice.to.domain.UserFullDetailsTO;

public class UserMapper {
    public static UserFullDetailsTO toFullDto(UserEntity entity){
        return new UserFullDetailsTO(
                entity.getUsername(),
                entity.getEmail()
        );
    }

    public static UserDetailsTO toDto(UserEntity entity){
        return new UserDetailsTO(
                entity.getId(),
                entity.getUsername()
        );
    }
}
