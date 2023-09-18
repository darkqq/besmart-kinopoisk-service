package com.besmartkinopoiskservice.exception;

import com.besmartkinopoiskservice.to.response.error.ExceptionResponseTO;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class WebExceptionHandler {
    @ExceptionHandler(ServiceException.class)
    @ResponseStatus(HttpStatus.SERVICE_UNAVAILABLE)
    public ExceptionResponseTO handlerException(ServiceException e) {
        return new ExceptionResponseTO(e.getMessage());
    }

    @ExceptionHandler(AuthenticationException.class)
    @ResponseStatus(HttpStatus.FORBIDDEN)
    public ExceptionResponseTO handlerException(AuthenticationException e) {
        return new ExceptionResponseTO(e.getMessage());
    }

}
