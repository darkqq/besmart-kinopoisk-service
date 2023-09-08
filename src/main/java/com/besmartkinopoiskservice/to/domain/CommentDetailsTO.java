package com.besmartkinopoiskservice.to.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.UUID;

@Data
@AllArgsConstructor
@RequiredArgsConstructor
public class CommentDetailsTO {
    private UUID commentId;
    private UUID movieID;
    private UUID ownerId;
    private String ownerUsername;
    private String text;
}
