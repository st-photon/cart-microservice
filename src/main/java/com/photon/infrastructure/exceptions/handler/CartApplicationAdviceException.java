package com.photon.infrastructure.exceptions.handler;

import com.photon.infrastructure.exceptions.ApiDataValidationException;
import com.photon.infrastructure.exceptions.BusinessDataValidationException;
import com.photon.infrastructure.exceptions.model.ApiDataError;
import com.photon.infrastructure.exceptions.model.BusinessDataError;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;

@RestControllerAdvice
public class CartApplicationAdviceException {

    @ExceptionHandler(ApiDataValidationException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public List<ApiDataError> handleApiDataError(ApiDataValidationException apiDataValidationException) {
        return apiDataValidationException.getApiDataErrors();
    }

    @ExceptionHandler(BusinessDataValidationException.class)
    public BusinessDataError handleBusinessData(){
        return BusinessDataError.of();
    }
}
