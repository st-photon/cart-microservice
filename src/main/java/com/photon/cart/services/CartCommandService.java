package com.photon.cart.services;


import com.photon.cart.request.AddCartItemRequest;
import com.photon.infrastructure.Response;

import java.util.UUID;

public interface CartCommandService {

    Response addToCart(AddCartItemRequest addCartItemRequest);

    void removeCartItem(int userId, UUID productId);
}
