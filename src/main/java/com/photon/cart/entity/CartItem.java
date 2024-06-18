package com.photon.cart.entity;


import com.photon.infrastructure.entity.BaseEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Table(name = "cart_item")
@Entity(name = "CartItem")
@Getter
@Setter
public class CartItem extends BaseEntity {

    @Column(name = "product_id", nullable = false)
    @Basic(optional = false)
    private UUID productId;

    @Column(name = "qty", nullable = false)
    @Basic(optional = false)
    private Long qty;

    @Column(name = "is_deleted", nullable = false)
    @Basic(optional = false)
    private boolean isDeleted;
}
