package com.photon.infrastructure.exceptions.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ApiDataError extends BaseDataError {

    private String fieldName;

    private String fieldErrorMessage;

    public static ApiDataError of() {
        return new ApiDataError();
    }
}
