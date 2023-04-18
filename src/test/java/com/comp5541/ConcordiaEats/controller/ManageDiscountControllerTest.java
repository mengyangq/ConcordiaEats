package com.comp5541.ConcordiaEats.controller;

import com.comp5541.ConcordiaEats.service.ProductService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class ManageDiscountControllerTest {

    @InjectMocks
    private ManageDiscountController manageDiscountController;

    @Mock
    private ProductService productService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this); // Initialize the mocks
    }

    @Test
    void testResetDiscount() {
        // Define the product ID to reset the discount for
        Integer productId = 100;

        // Call the resetDiscount method
        String result = manageDiscountController.resetDiscount(productId);

        // Verify that the productService.resetDiscount method was called with the correct ID
        verify(productService, times(1)).resetDiscount(productId);

        // Verify the returned view name
        assertEquals("redirect:/admin/discounts", result);
    }

    @Test
    void testUpdateDiscount() {
        // Define the product ID and discount value
        Integer productId = 100;
        Integer discount = 10;

        // Call the updateDiscount method
        String result = manageDiscountController.updateDiscount(discount, productId);

        // Verify that the productService.updateDiscount method was called with the correct arguments
        verify(productService, times(1)).updateDiscount(discount, productId);

        // Verify the returned view name
        assertEquals("redirect:/admin/discounts", result);
    }
}
