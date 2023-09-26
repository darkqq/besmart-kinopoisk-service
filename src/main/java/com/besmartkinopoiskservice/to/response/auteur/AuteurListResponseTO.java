package com.besmartkinopoiskservice.to.response.auteur;

import com.besmartkinopoiskservice.to.domain.AuteurDetailsTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@AllArgsConstructor
@RequiredArgsConstructor
public class AuteurListResponseTO {
    private AuteurDetailsTO auteurDetails;
}
