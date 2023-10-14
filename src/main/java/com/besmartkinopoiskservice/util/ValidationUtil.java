package com.besmartkinopoiskservice.util;


import com.besmartkinopoiskservice.exception.ServiceException;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validator;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
@RequiredArgsConstructor
public class ValidationUtil {
    private final Validator validator;

    public <T> void checkCredentials(T request) throws ServiceException {
        Set<ConstraintViolation<T>> result = validator.validate(request);
        if (result.size() != 0){
            throw new ServiceException(result.stream().map(ConstraintViolation::getMessage).reduce((s1, s2) -> s1 + ". " + s2).orElse(""));
        }
    }
}
