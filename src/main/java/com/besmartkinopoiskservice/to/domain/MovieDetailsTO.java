package com.besmartkinopoiskservice.to.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.time.LocalDate;
import java.util.UUID;

@Data
@AllArgsConstructor
@RequiredArgsConstructor
public class MovieDetailsTO {
    private UUID image;
    private String title;
    private double rating;
    private String description;
    private double boxOffice;
    private LocalDate premiere;
}
