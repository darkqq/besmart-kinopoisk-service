package com.besmartkinopoiskservice.to.request.user;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.UUID;

@Data
@AllArgsConstructor
@RequiredArgsConstructor
public class AddFavoriteRequestTO {
    private UUID userId;
    private UUID movieID;
}
