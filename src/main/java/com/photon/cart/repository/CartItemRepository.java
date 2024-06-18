package com.photon.cart.repository;


import com.photon.cart.entity.CartItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.UUID;

public interface CartItemRepository extends JpaRepository<CartItem, UUID> {

    @Modifying
    @Query("DELETE CartItem ct WHERE ct.id = :cartItemId")
    void deleteEntityById(@Param("cartItemId") UUID cartItemId);
}
