package com.comp5541.ConcordiaEats.controller;

import com.comp5541.ConcordiaEats.model.Product;
import com.comp5541.ConcordiaEats.service.ProductService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.ui.Model;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class ManageProductsControllerTest {

    @InjectMocks
    private ManageProductsController manageProductsController;

    @Mock
    private ProductService productService;

    @Mock
    private Model model;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testDeleteProducts() {
        Integer productId = 100;
        String result = manageProductsController.deleteProducts(productId);
        verify(productService, times(1)).deleteProduct(productId);
        assertEquals("redirect:/admin/products", result);
    }

    @Test
    void testUpdateProducts() {
        Integer id = 100;
        String name = "Product A";
        Integer categoryid = 1;
        Integer quantity = 10;
        Double price = 12.99;
        Integer weight = 500;
        String description = "Test product";
        String image = "https://placehold.co/100x100.png";

        when(productService.searchProducts()).thenReturn(Arrays.asList(new Product()));
        String result = manageProductsController.updateProducts(id, name, categoryid, quantity, price, weight, description, image, model);
        verify(productService, times(1)).updateProduct(id, name, categoryid, quantity, price, weight, description, image);
        assertEquals("adminProducts", result);
    }

    @Test
    void testInsertProducts() {
        String name = "Product B";
        Integer categoryid = 2;
        Integer quantity = 20;
        Double price = 15.99;
        Integer weight = 700;
        String description = "New product";
        String image = "https://placehold.co/100x100.png";

        when(productService.searchProducts()).thenReturn(Arrays.asList(new Product()));
        String result = manageProductsController.insertProducts(name, categoryid, quantity, price, weight, description, image, model);
        verify(productService, times(1)).insertProduct(name, categoryid, quantity, price, weight, description, image);
        assertEquals("adminProducts", result);
    }
}
