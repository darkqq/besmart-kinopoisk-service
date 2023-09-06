package com.besmartkinopoiskservice.to.response.auteurresponse;

import com.besmartkinopoiskservice.to.domain.AuteurPageDetailsTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@AllArgsConstructor
@RequiredArgsConstructor
public class GetAuteurPageResponseTO {
    private AuteurPageDetailsTO auteurDetail;
}
