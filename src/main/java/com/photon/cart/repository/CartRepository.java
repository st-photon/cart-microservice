package com.photon.cart.repository;


import com.photon.cart.entity.Cart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;
import java.util.UUID;

public interface CartRepository extends JpaRepository<Cart, UUID> {

    @Query("SELECT c FROM Cart c WHERE c.userId=:userId AND c.isCheckedOut=false")
    Optional<Cart> findActiveCartByUserId(@Param("userId") int userId);

}
