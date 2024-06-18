package com.photon.infrastructure.exceptions;

import com.photon.infrastructure.exceptions.model.ApiDataError;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class ApiDataValidationException extends AbstractCartException {

    private List<ApiDataError> apiDataErrors = new ArrayList<>();

    public ApiDataValidationException(List<ApiDataError> errors){
        super();
        this.apiDataErrors = errors;
    }

}
