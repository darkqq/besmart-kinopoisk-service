package com.besmartkinopoiskservice.to.response.user;


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
