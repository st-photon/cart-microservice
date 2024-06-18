package com.photon.infrastructure.exceptions.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BusinessDataError extends BaseDataError {

    public static BusinessDataError of() {
        return new BusinessDataError();
    }
}
