package com.besmartkinopoiskservice.to.response.user;

import com.besmartkinopoiskservice.to.domain.UserShortDetailsTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@AllArgsConstructor
@RequiredArgsConstructor
public class GetUserShortInfoResponseTO {
    private UserShortDetailsTO userDetails;
}