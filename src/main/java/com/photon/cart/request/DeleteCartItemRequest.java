package com.photon.cart.request;

import lombok.Data;

import java.util.UUID;

@Data
public class DeleteCartItemRequest {

    private int userId;

    private UUID productId;
}
