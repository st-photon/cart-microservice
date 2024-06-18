package com.photon.cart.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.photon.dto.ProductDTO;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class CartItemDTO {

    @JsonProperty("product")
    private ProductDTO productDTO;

    private Long qty;
}
