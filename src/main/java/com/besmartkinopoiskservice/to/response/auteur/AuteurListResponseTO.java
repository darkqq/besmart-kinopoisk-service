package com.besmartkinopoiskservice.to.response.auteur;

import com.besmartkinopoiskservice.to.domain.AuteurDetailsTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@RequiredArgsConstructor
public class AuteurListResponseTO {
    private List<AuteurDetailsTO> auteurDetails;
}
