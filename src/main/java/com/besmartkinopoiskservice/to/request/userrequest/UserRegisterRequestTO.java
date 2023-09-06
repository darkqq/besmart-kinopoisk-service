package com.besmartkinopoiskservice.to.request.userrequest;

import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;

@Data
@AllArgsConstructor
@RequiredArgsConstructor
public class UserRegisterRequestTO {
    private String username;
    private String password;
    private String passwordConfirmation;
    private String email;
}
