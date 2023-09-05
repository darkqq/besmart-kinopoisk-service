package com.besmartkinopoiskservice.to.request.auteurrequest;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.UUID;

@Data
@AllArgsConstructor
@RequiredArgsConstructor
public class UpdateAuteurPhotoRequestTO {
    private UUID auteurId;
    private UUID photo;
}
