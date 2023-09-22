package com.besmartkinopoiskservice.exception;

import com.besmartkinopoiskservice.controller.AuthenticationController;
import com.besmartkinopoiskservice.service.AuthenticationService;
import com.besmartkinopoiskservice.to.response.error.ExceptionResponseTO;
import io.jsonwebtoken.ExpiredJwtException;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    public ExceptionResponseTO handlerException(AuthenticationException e) {
        return new ExceptionResponseTO(e.getMessage());
    }
}
