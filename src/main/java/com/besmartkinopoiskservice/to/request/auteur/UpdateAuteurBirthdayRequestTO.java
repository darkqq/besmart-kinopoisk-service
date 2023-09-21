package com.besmartkinopoiskservice.to.request.auteur;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.time.LocalDate;
import java.util.UUID;

@Data
@AllArgsConstructor
@RequiredArgsConstructor
public class UpdateAuteurBirthdayRequestTO {
    private UUID auteurId;
    private LocalDate birthday;
}
