package com.besmartkinopoiskservice.to.response.error;

import org.springframework.http.HttpStatusCode;
import org.springframework.http.ProblemDetail;
import org.springframework.web.ErrorResponse;

public class AuthErrorResponseTO implements ErrorResponse {
    @Override
    public HttpStatusCode getStatusCode() {
        return null;
    }

    @Override
    public ProblemDetail getBody() {
        return null;
    }
}
