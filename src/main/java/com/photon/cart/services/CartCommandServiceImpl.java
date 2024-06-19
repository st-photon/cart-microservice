package com.photon.cart.services;


import com.photon.cart.entity.Cart;
import com.photon.cart.entity.CartItem;
import com.photon.cart.repository.CartItemRepository;
import com.photon.cart.repository.CartRepository;
import com.photon.cart.repository.CartRepositoryWrapper;
import com.photon.cart.request.AddCartItemRequest;
import com.photon.consumers.ProductConsumer;
import com.photon.consumers.UserConsumer;
import com.photon.dto.ProductDTO;
import com.photon.dto.UserDTO;
import com.photon.infrastructure.Response;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;
import java.util.UUID;

@Service
@Slf4j
@RequiredArgsConstructor
public class CartCommandServiceImpl implements CartCommandService {

    private final ProductConsumer productConsumer;

    private final CartRepository cartRepository;

    private final UserConsumer userConsumer;

    private final CartRepositoryWrapper cartRepositoryWrapper;

    private final CartItemRepository cartItemRepository;

    @Override
    @Transactional
    public Response addToCart(AddCartItemRequest addCartItemRequest) {
        final ProductDTO product = this.productConsumer.getProductById(addCartItemRequest.getProductId());
        final UserDTO user = userConsumer.getUserById(addCartItemRequest.getUserId());
        final Optional<Cart> cartOptional = cartRepositoryWrapper.findActiveCartByUserId(user.getUserId());
        if(cartOptional.isEmpty()) {
            Cart cart = new Cart();
            cart.setCheckedOut(false);
            cart.setDeleted(false);
            cart.setUserId(user.getUserId());
            cart.getCartItems().add(createCartItem(product, addCartItemRequest.getQty()));
            final Cart newCart = this.cartRepository.saveAndFlush(cart);
            return Response.of(newCart.getId());
        }
        Cart cart = cartOptional.get();
        Optional<CartItem> cartItemOptional = cart.getCartItems()
                .stream()
                .filter(c -> c.getProductId().equals(product.getId()))
                .findFirst();
        if(cartItemOptional.isEmpty()) {
            cart.getCartItems().add(createCartItem(product, addCartItemRequest.getQty()));
        } else {
            cartItemOptional.get().setQty(addCartItemRequest.getQty());
        }
        cart = this.cartRepository.saveAndFlush(cart);
        return Response.of(cart.getId());
    }

    private CartItem createCartItem(ProductDTO product, Long qty) {
        final CartItem cartItem = new CartItem();
        cartItem.setProductId(product.getId());
        cartItem.setQty(qty);
        cartItem.setDeleted(false);
        return cartItem;
    }


    @Transactional
    @Override
    public void removeCartItem(int userId, UUID productId) {
        try {
            final UserDTO user = userConsumer.getUserById(userId);
            final Optional<Cart> cartOptional = cartRepositoryWrapper.findActiveCartByUserId(user.getUserId());
            if(cartOptional.isEmpty()) {
                throw new IllegalArgumentException("Active cart not available for this user");
            }
            Cart cart = cartOptional.get();
            Optional<CartItem> cartItemOptional = cart.getCartItems()
                    .stream()
                    .filter(c -> c.getProductId().equals(productId))
                    .findFirst();
            if(cartItemOptional.isEmpty()) {
                throw new IllegalArgumentException("Product not available for this user cart");
            }
            this.cartItemRepository.deleteEntityById(cartItemOptional.get().getId());
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }
}
