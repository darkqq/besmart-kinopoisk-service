package com.besmartkinopoiskservice.to.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.UUID;

@Data
@AllArgsConstructor
@RequiredArgsConstructor
public class ResourceResponseTO {
    private UUID resourceId;
}
