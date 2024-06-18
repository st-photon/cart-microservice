package com.photon.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class ProductDTO {

    private UUID id;

    private String name;

    private String price;
}
