package com.besmartkinopoiskservice.to.request.userrequest;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@AllArgsConstructor
@RequiredArgsConstructor
public class UserLogInRequestTO {
    private String username;
    private String password;
}
