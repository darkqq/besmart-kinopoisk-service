package com.besmartkinopoiskservice.service;

import com.besmartkinopoiskservice.exception.ServiceException;
import com.besmartkinopoiskservice.to.response.GetCommentsResponseTO;

import java.util.UUID;

public interface CommentService {
    GetCommentsResponseTO getComments(UUID movieId, UUID userId) throws ServiceException;
}
