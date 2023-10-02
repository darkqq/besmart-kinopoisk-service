package com.besmartkinopoiskservice.to.response.user;

import com.besmartkinopoiskservice.to.domain.UserDetailsTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@RequiredArgsConstructor
public class UsersListResponseTO {
    private List<UserDetailsTO> usersList;
}
