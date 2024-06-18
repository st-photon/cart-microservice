package com.photon.cart.services;


import com.photon.cart.dto.CartDTO;

public interface CartQueryService {

    CartDTO fetchMyCart(int userId);
}
