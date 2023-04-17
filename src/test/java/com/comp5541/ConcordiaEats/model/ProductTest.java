package com.comp5541.ConcordiaEats.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ProductTest {
    private Product product;

    @BeforeEach
    public void setUp() {
        // Initialize a new Product object before each test
        product = new Product();
    }

    @Test
    public void testId() {
        // Set an ID and check if the getter returns the correct value
        product.setId(1);
        assertEquals(1, product.getId());
    }

    @Test
    public void testName() {
        // Set a name and check if the getter returns the correct value
        product.setName("Test Product");
        assertEquals("Test Product", product.getName());
    }

    @Test
    public void testCategoryid() {
        // Set a category ID and check if the getter returns the correct value
        product.setCategoryid(2);
        assertEquals(2, product.getCategoryid());
    }

    @Test
    public void testImage() {
        // Set an image URL and check if the getter returns the correct value
        product.setImage("/images/test.jpg");
        assertEquals("/images/test.jpg", product.getImage());
    }

    @Test
    public void testQuantity() {
        // Set a quantity and check if the getter returns the correct value
        product.setQuantity(5);
        assertEquals(5, product.getQuantity());
    }

    @Test
    public void testPrice() {
        // Set a price and check if the getter returns the correct value
        product.setPrice(9.99);
        assertEquals(9.99, product.getPrice());
    }

    @Test
    public void testOnsale() {
        // Set an onsale status and check if the getter returns the correct value
        product.setOnsale(1);
        assertEquals(1, product.getOnsale());
    }

    @Test
    public void testDiscount() {
        // Set a discount and check if the getter returns the correct value
        product.setDiscount(10);
        assertEquals(10, product.getDiscount());
    }

    @Test
    public void testWeight() {
        // Set a weight and check if the getter returns the correct value
        product.setWeight(500);
        assertEquals(500, product.getWeight());
    }

    @Test
    public void testDescription() {
        // Set a description and check if the getter returns the correct value
        product.setDescription("Test description");
        assertEquals("Test description", product.getDescription());
    }

    @Test
    public void testSold() {
        // Set a sold count and check if the getter returns the correct value
        product.setSold(3);
        assertEquals(3, product.getSold());
    }
}
