package com.besmartkinopoiskservice.to.request.user;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@AllArgsConstructor
@RequiredArgsConstructor
public class UpdateUserDetailsRequestTO {
    private String username;
    private String password;
    private String passwordConfirmation;
    private String email;
}
