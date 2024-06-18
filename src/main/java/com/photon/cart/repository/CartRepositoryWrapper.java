package com.photon.cart.repository;

import com.photon.cart.entity.Cart;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.Optional;
import java.util.UUID;

@Component
@Slf4j
@RequiredArgsConstructor
public class CartRepositoryWrapper {

    private final CartRepository cartRepository;

    public Cart findById(UUID cartId) {
        return cartRepository.findById(cartId).orElseThrow(() -> new RuntimeException("Cart not found with this id"));
    }

    public Optional<Cart> findActiveCartByUserId(int userId) {
        return cartRepository.findActiveCartByUserId(userId);
    }
}
