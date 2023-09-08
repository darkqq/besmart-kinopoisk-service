package com.besmartkinopoiskservice.util.mapper;

import com.besmartkinopoiskservice.domain.CommentEntity;
import com.besmartkinopoiskservice.to.domain.CommentDetailsTO;

public class CommentMapper {
    public CommentDetailsTO toDto(CommentEntity entity){
        return new CommentDetailsTO(
                entity.getId(),
                entity.getMovie().getId(),
                entity.getAuthor().getId(),
                entity.getAuthor().getUsername(),
                entity.getCommentText()
        );
    }
}