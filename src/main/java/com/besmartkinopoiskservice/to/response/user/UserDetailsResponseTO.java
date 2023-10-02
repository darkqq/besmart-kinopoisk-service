package com.besmartkinopoiskservice.to.response.user;

import com.besmartkinopoiskservice.to.domain.UserFullDetailsTO;
import lombok.Data;

@Data
public class UserDetailsResponseTO extends UserFullDetailsTO {
    public UserDetailsResponseTO(UserFullDetailsTO userDetails){
        this.setUsername(userDetails.getUsername());
        this.setEmail(userDetails.getEmail());
    }
}
