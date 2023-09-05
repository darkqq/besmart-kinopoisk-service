package com.besmartkinopoiskservice.to.request.auteurrequest;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.time.LocalDate;
import java.util.UUID;

@Data
@AllArgsConstructor
@RequiredArgsConstructor
public class CreateAuteurRequestTO {
    private String name;
    private String description;
    private UUID image;
    private LocalDate birthday;
}
