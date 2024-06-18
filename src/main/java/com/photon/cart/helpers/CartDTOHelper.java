package com.photon.cart.helpers;


import com.photon.cart.dto.CartDTO;
import com.photon.cart.dto.CartItemDTO;
import com.photon.cart.entity.Cart;
import com.photon.cart.entity.CartItem;
import com.photon.consumers.ProductConsumer;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Slf4j
@RequiredArgsConstructor
public class CartDTOHelper {

    private final CartCalculatorHelper cartCalculatorHelper;

    private final ProductConsumer productConsumer;

    public CartDTO createCartDTO(final Cart cart) {
        final CartDTO cartDTO = new CartDTO();
        cartDTO.setSubTotal(cartCalculatorHelper.calculateSubtotal(cart.getCartItems()));
        cartDTO.setTotalQty(cartCalculatorHelper.calculateTotalQty(cart.getCartItems()));
        cartDTO.setCartItemDTOList(map(cart.getCartItems()));
        return cartDTO;
    }

    private List<CartItemDTO> map(List<CartItem> cartItems) {
        return cartItems.stream()
                .map(ci -> CartItemDTO
                        .builder()
                        .qty(ci.getQty())
                        .productDTO(productConsumer.getProductById(ci.getProductId()))
                        .build()).toList();
    }
}
