package com.besmartkinopoiskservice.to.response.auteur;

import com.besmartkinopoiskservice.to.domain.AuteurFullDetailsTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@AllArgsConstructor
@RequiredArgsConstructor
public class AuteurDetailsResponseTO {
    private AuteurFullDetailsTO auteurDetail;
}
