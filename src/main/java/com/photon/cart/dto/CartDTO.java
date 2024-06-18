package com.photon.cart.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CartDTO implements Serializable {

    @JsonProperty("sub_total")
    private BigDecimal subTotal = BigDecimal.ZERO;

    @JsonProperty("total_qty")
    private Long totalQty = 0L;

    @JsonProperty("items")
    private List<CartItemDTO> cartItemDTOList = new ArrayList<>();
}
