package com.photon.cart.request;

import lombok.Data;

import java.io.Serializable;
import java.util.UUID;

@Data
public class AddCartItemRequest implements Serializable {

    private UUID productId;

    private Long qty;

    private int userId;
}
