package com.comp5541.ConcordiaEats.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class CartIdTest {

    @Test
    public void testEqualsAndHashCode() {
        // Create two CartId objects with the same user_id and product_id
        Cart.CartId cartId1 = new Cart.CartId();
        cartId1.setUser_id(1);
        cartId1.setProduct_id(100);

        Cart.CartId cartId2 = new Cart.CartId();
        cartId2.setUser_id(1);
        cartId2.setProduct_id(100);

        // Create a third CartId object with different user_id and product_id
        Cart.CartId cartId3 = new Cart.CartId();
        cartId3.setUser_id(2);
        cartId3.setProduct_id(200);

        // Assert that the two CartId objects with the same user_id and product_id are equal
        assertEquals(cartId1, cartId2);
        // Assert that their hash codes are equal
        assertEquals(cartId1.hashCode(), cartId2.hashCode());

        // Assert that the two CartId objects with different user_id and product_id are not equal
        assertNotEquals(cartId1, cartId3);
        // Assert that their hash codes are not equal
        assertNotEquals(cartId1.hashCode(), cartId3.hashCode());
    }
}
