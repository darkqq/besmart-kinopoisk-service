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
    private String ownerUsername;
    private UUID ownerId;
    private String text;
}
