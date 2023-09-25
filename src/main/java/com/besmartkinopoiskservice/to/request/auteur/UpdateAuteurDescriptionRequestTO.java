package com.besmartkinopoiskservice.to.request.auteur;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.UUID;

@Data
@AllArgsConstructor
@RequiredArgsConstructor
public class UpdateAuteurDescriptionRequestTO {
    private UUID auteurId;
    private String description;
}