package com.besmartkinopoiskservice.to.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.time.LocalDate;
import java.util.UUID;

@Data
@AllArgsConstructor
@RequiredArgsConstructor
public class AuteurShortDetailsTO {
    private UUID auteurId;
    private String name;
    private String description;
    private UUID image;
    private LocalDate birthday;
}
