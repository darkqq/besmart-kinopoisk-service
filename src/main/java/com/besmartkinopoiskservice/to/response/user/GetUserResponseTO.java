package com.besmartkinopoiskservice.to.response.user;

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
