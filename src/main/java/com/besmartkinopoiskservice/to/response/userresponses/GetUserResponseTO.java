package com.besmartkinopoiskservice.to.response.userresponses;

import com.besmartkinopoiskservice.to.domain.UserDetailsTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@AllArgsConstructor
@RequiredArgsConstructor
public class GetUserResponseTO {
    private UserDetailsTO userPageDetails;
}
