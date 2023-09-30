package com.besmartkinopoiskservice.to.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.UUID;

@Data
@AllArgsConstructor
@RequiredArgsConstructor
public class AuteurDetailsTO {
    private UUID auteurId;
    private String name;
    private String image;
}
