package com.comp5541.ConcordiaEats.controller;

import com.comp5541.ConcordiaEats.controller.CartController;
import com.comp5541.ConcordiaEats.model.CartItemInfo;
import com.comp5541.ConcordiaEats.model.Product;
import com.comp5541.ConcordiaEats.service.CartService;
import com.comp5541.ConcordiaEats.service.CheckoutService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

class CartControllerTest {
    @InjectMocks
    CartController cartController;

    @Mock
    CartService cartService;

    @Mock
    CheckoutService checkoutService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testUpdateCartQuantity() {
        doNothing().when(cartService).updateCartQuantity(anyInt(), anyInt(), anyInt());

        ResponseEntity<String> responseEntity = cartController.updateCartQuantity(1, 100, 2);
        assertEquals(200, responseEntity.getStatusCodeValue());
        assertEquals("Cart quantity updated successfully.", responseEntity.getBody());
    }

    @Test
    void testRemoveFromCart() {
        RedirectAttributes redirectAttributes = mock(RedirectAttributes.class);
        String result = cartController.removeFromCart(1, 100, redirectAttributes);
        assertEquals("redirect:/cart", result);
    }

    @Test
    void testPerformCheckout() {
        Model model = mock(Model.class);
        List<CartItemInfo> cartItems = new ArrayList<>();
        Product product = new Product();
        product.setId(100);
        cartItems.add(new CartItemInfo(product, 2));

        when(cartService.getCartItemsByUserId(anyInt())).thenReturn(cartItems);

        String result = cartController.performCheckout(1, model);
        assertEquals("cart", result);
    }
}
