package com.besmartkinopoiskservice.to.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Data
@AllArgsConstructor
@RequiredArgsConstructor
public class MovieFullDetailsTO {
    private UUID id;
    private String image;
    private String title;
    private double rating;
    private String description;
    private double boxOffice;
    private LocalDate premiere;

    private List<AuteurDetailsTO> actors;
    private List<AuteurDetailsTO> directors;


}
