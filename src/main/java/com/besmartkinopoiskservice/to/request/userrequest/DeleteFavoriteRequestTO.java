package com.besmartkinopoiskservice.to.request.userrequest;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.UUID;

@Data
@AllArgsConstructor
@RequiredArgsConstructor
public class DeleteFavoriteRequestTO {
    private UUID userId;
    private UUID movieId;
}
