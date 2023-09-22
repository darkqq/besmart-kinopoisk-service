package com.besmartkinopoiskservice.to.response.error;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@AllArgsConstructor
@RequiredArgsConstructor
public class ExceptionResponseTO {
    private String error;
}
