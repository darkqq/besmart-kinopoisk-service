package com.besmartkinopoiskservice.to.response.auteurresponse;

import com.besmartkinopoiskservice.to.domain.AuteurShortDetailsTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@AllArgsConstructor
@RequiredArgsConstructor
public class GetAuteurResponseTO {
    private AuteurShortDetailsTO auteurDetails;
}
