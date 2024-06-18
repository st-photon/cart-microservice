package com.photon.cart.api;


import com.photon.cart.dto.CartDTO;
import com.photon.cart.request.AddCartItemRequest;
import com.photon.cart.request.DeleteCartItemRequest;
import com.photon.cart.services.CartCommandService;
import com.photon.cart.services.CartQueryService;
import com.photon.infrastructure.Response;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/carts")
@Tag(name = "CartApiResource")
public class CartApiResource {

    private final CartCommandService cartCommandService;

    private final CartQueryService cartQueryService;

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public Response addItemToCart(@RequestBody AddCartItemRequest addCartItemRequest) {
        return cartCommandService.addToCart(addCartItemRequest);
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public CartDTO fetchMyCart(@RequestParam("userId") int userId) {
        return cartQueryService.fetchMyCart(userId);
    }

    @DeleteMapping(value = "/item", produces = MediaType.APPLICATION_JSON_VALUE)
    public void deleteCartItem(@RequestBody DeleteCartItemRequest deleteCartItemRequest) {
        cartCommandService.removeCartItem(deleteCartItemRequest.getUserId(), deleteCartItemRequest.getProductId());
    }
}
