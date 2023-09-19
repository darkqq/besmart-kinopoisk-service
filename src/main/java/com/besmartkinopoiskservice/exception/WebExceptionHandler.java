package com.besmartkinopoiskservice.exception;

import com.besmartkinopoiskservice.to.response.error.ExceptionResponseTO;
import io.jsonwebtoken.ExpiredJwtException;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.io.IOException;

@RestControllerAdvice
public class WebExceptionHandler {
    @ExceptionHandler(ServiceException.class)
    @ResponseStatus(HttpStatus.SERVICE_UNAVAILABLE)
    public ExceptionResponseTO handlerException(ServiceException e) {
        return new ExceptionResponseTO(e.getMessage());
    }

//    @ExceptionHandler(AuthenticationException.class)
//    @ResponseStatus(HttpStatus.FORBIDDEN)
//    public ExceptionResponseTO handlerException(AuthenticationException e) {
//        return new ExceptionResponseTO(e.getMessage());
//    }

    @ExceptionHandler(AuthenticationException.class)
    public void handlerException(AuthenticationException e, HttpServletResponse response) throws IOException {
        response.setStatus(HttpStatus.UNAUTHORIZED.value());
        response.getWriter().write(e.getMessage());
    }

    @ExceptionHandler(ExpiredJwtException.class)
    @ResponseStatus(HttpStatus.FORBIDDEN)
    public ExceptionResponseTO handlerException(ExpiredJwtException e) {
        return new ExceptionResponseTO(e.getMessage());
    }
}
