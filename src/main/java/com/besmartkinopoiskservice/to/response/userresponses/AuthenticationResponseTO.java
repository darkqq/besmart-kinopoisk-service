package com.besmartkinopoiskservice.to.response.userresponses;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@AllArgsConstructor
@RequiredArgsConstructor
@Builder
public class AuthenticationResponseTO {
    private String token;
}
