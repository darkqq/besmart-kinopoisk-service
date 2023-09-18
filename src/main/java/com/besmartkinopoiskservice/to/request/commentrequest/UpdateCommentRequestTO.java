package com.besmartkinopoiskservice.to.request.commentrequest;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.UUID;

@Data
@AllArgsConstructor
@RequiredArgsConstructor
public class UpdateCommentRequestTO {
    private UUID commentId;
    private String commentText;
}
