package com.photon.infrastructure.exceptions.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

@Data
public abstract class BaseDataError {

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String message;
}
