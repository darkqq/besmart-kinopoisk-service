package com.besmartkinopoiskservice.exception;

public class ServiceException extends Exception{
    public ServiceException(String errorMessage){
        super(errorMessage);
    }
}
