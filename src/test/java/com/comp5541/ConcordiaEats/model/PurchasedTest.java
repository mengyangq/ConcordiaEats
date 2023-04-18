package com.comp5541.ConcordiaEats.model;

import com.comp5541.ConcordiaEats.model.Purchased;
import com.comp5541.ConcordiaEats.model.Purchased.PurchasedId;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class PurchasedTest {

    @Test
    public void testPurchasedId() {
        // Create two PurchasedId instances with the same user_id and product_id
        PurchasedId purchasedId1 = new PurchasedId();
        purchasedId1.setUser_id(1);
        purchasedId1.setProduct_id(100);

        PurchasedId purchasedId2 = new PurchasedId();
        purchasedId2.setUser_id(1);
        purchasedId2.setProduct_id(100);

        // Assert that the two PurchasedId instances are equal and have the same hashCode
        assertEquals(purchasedId1, purchasedId2);
        assertEquals(purchasedId1.hashCode(), purchasedId2.hashCode());

        // Change the product_id of purchasedId2
        purchasedId2.setProduct_id(200);

        // Assert that the two PurchasedId instances are not equal and have different hashCodes
        assertNotEquals(purchasedId1, purchasedId2);
        assertNotEquals(purchasedId1.hashCode(), purchasedId2.hashCode());
    }

    @Test
    public void testPurchased() {
        // Create a Purchased instance and set its properties
        Purchased purchased = new Purchased();

        PurchasedId purchasedId = new PurchasedId();
        purchasedId.setUser_id(1);
        purchasedId.setProduct_id(100);
        purchased.setId(purchasedId);

        purchased.setQuantity(5);

        // Assert that the properties of the Purchased instance are correctly set
        assertEquals(purchasedId, purchased.getId());
        assertEquals(Integer.valueOf(5), purchased.getQuantity());
    }
}
