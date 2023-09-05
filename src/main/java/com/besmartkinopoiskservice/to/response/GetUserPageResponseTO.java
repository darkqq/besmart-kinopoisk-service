package com.besmartkinopoiskservice.to.response;

import com.besmartkinopoiskservice.to.domain.UserPageDetailsTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@AllArgsConstructor
@RequiredArgsConstructor
public class GetUserPageResponseTO {
    private UserPageDetailsTO userPageDetails;
}
