package com.photon.cart.helpers;

import com.photon.cart.entity.CartItem;
import com.photon.consumers.ProductConsumer;
import com.photon.dto.ProductDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Component
@Slf4j
@RequiredArgsConstructor
public class CartCalculatorHelper {

    private final ProductConsumer productConsumer;

    public BigDecimal calculateSubtotal(final List<CartItem> cartItemList) {
        List<Double> itemAmounts = new ArrayList<>();
        cartItemList.forEach(ci -> {
            final ProductDTO productDTO = productConsumer.getProductById(ci.getProductId());
            double itemAmount = Double.parseDouble(productDTO.getPrice()) * ci.getQty();
            itemAmounts.add(itemAmount);
        });
        return BigDecimal.valueOf(itemAmounts.stream().mapToDouble(Double::doubleValue).sum());
    }

    public Long calculateTotalQty(final List<CartItem> cartItemList) {
        return cartItemList
                .stream()
                .filter(ci -> ci.getQty() != null)
                .mapToLong(CartItem::getQty).sum();
    }
}
