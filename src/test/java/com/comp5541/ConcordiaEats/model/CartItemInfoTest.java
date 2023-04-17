package com.comp5541.ConcordiaEats.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class CartItemInfoTest {

    @Test
    public void testCartItemInfo() {
        // Create a Product object for testing
        Product product1 = new Product();
        product1.setId(1);
        product1.setName("Laptop");
        product1.setPrice(1500.00);

        // Create a CartItemInfo object and set its properties
        CartItemInfo cartItem1 = new CartItemInfo(product1, 2);

        // Assert that the properties are set correctly
        assertEquals(product1, cartItem1.getProduct());
        assertEquals(2, cartItem1.getQuantity());

        // Create another Product object for testing
        Product product2 = new Product();
        product2.setId(2);
        product2.setName("Mouse");
        product2.setPrice(30.00);

        // Create another CartItemInfo object with different properties
        CartItemInfo cartItem2 = new CartItemInfo(product2, 1);

        // Assert that the properties are set correctly
        assertEquals(product2, cartItem2.getProduct());
        assertEquals(1, cartItem2.getQuantity());

        // Assert that the two CartItemInfo objects are not equal
        assertNotEquals(cartItem1, cartItem2);
    }
}
