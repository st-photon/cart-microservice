package com.photon.cart.services;


import com.photon.cart.dto.CartDTO;
import com.photon.cart.entity.Cart;
import com.photon.cart.helpers.CartDTOHelper;
import com.photon.cart.repository.CartRepositoryWrapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Slf4j
@RequiredArgsConstructor
public class CartQueryServiceImpl implements CartQueryService {

    private final CartRepositoryWrapper cartRepositoryWrapper;

    private final CartDTOHelper cartDTOHelper;

    public CartDTO fetchMyCart(int userId) {
        final Optional<Cart> cart = cartRepositoryWrapper.findActiveCartByUserId(userId);
        return cart.map(cartDTOHelper::createCartDTO).orElse(null);
    }
}
