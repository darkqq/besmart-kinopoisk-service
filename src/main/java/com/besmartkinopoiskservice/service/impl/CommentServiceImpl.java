package com.besmartkinopoiskservice.service.impl;

import com.besmartkinopoiskservice.domain.CommentEntity;
import com.besmartkinopoiskservice.exception.ServiceException;
import com.besmartkinopoiskservice.repository.CommentRepository;
import com.besmartkinopoiskservice.service.CommentService;
import com.besmartkinopoiskservice.to.domain.CommentDetailsTO;
import com.besmartkinopoiskservice.to.response.GetCommentsResponseTO;
import com.besmartkinopoiskservice.util.mapper.CommentMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class CommentServiceImpl implements CommentService {
    private final CommentRepository commentRepository;

    @Override
    public GetCommentsResponseTO getComments(UUID movieId, UUID userId) throws ServiceException {
        List<CommentEntity>  comments = new ArrayList<>();
        if (userId != null && movieId != null){
            comments = commentRepository.findAllByAuthorIdAndMovieId(userId, movieId);
        }
        else if (userId != null){
            comments = commentRepository.findAllByAuthorId(userId);
        }
        else if (movieId != null){
            comments = commentRepository.findAllByMovieId(movieId);
        }
        else {
            throw new ServiceException("Не указаны параметры поиска комментариев");
        }

        List<CommentDetailsTO> commentDetails = comments.stream().map(CommentMapper::toDto).toList();
        return new GetCommentsResponseTO(commentDetails);
    }
}