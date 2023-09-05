package com.besmartkinopoiskservice.to.response.userresponses;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@AllArgsConstructor
@RequiredArgsConstructor
public class AuthenticationResponseTO {
    private String token;
}
