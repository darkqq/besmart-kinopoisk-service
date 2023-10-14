package com.besmartkinopoiskservice.to.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.UUID;

@Data
@AllArgsConstructor
@RequiredArgsConstructor
public class UserDetailsTO {
    private UUID userId;
    private String username;
}
