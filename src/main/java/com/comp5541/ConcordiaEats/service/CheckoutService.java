package com.comp5541.ConcordiaEats.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.comp5541.ConcordiaEats.model.*;
import com.comp5541.ConcordiaEats.repository.PurchasedRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Service
public class CheckoutService {
    @Autowired
    private CartService cartService;
    
    @Autowired
    private ProductService productService;
    
    @Autowired
    private PurchasedRepository purchasedRepository;
    
    private static final Logger logger = LoggerFactory.getLogger(CheckoutService.class);

    
    @Transactional
    public void performCheckout(Integer userId) {
    	
    	logger.info("Starting checkout process for user with ID: {}", userId);
        // Step 1: Retrieve the current user's cart items
        List<CartItemInfo> cartItems = cartService.getCartItemsByUserId(userId);
        
        // Step 2-4: Iterate through each cart item and update the products table
        for (CartItemInfo cartItem : cartItems) {
            Integer productId = cartItem.getProduct().getId();
            Integer quantityPurchased = cartItem.getQuantity();
            
            // Retrieve the corresponding product from the products table
            Product product = productService.searchProducts(productId);
            
            // Update the quantity and sold attributes of the product
            product.setQuantity(product.getQuantity() - quantityPurchased);
            product.setSold(product.getSold() + quantityPurchased);
            
            // Persist the updated product information back to the products table
            productService.updateProduct(product);
            
            Purchased.PurchasedId purchasedId = new Purchased.PurchasedId();
            purchasedId.setUser_id(userId);
            purchasedId.setProduct_id(productId);

            // Check if the item already exists in the purchased table
            Purchased purchasedItem = purchasedRepository.findById(purchasedId).orElse(null);

            if (purchasedItem == null) {
                // If not, create a new purchased item with the same quantity as the cart item
                purchasedItem = new Purchased();
                purchasedItem.setId(purchasedId);
                purchasedItem.setQuantity(cartItem.getQuantity());
            } else {
                // If it exists, update the quantity by adding the new quantity from the cart
                purchasedItem.setQuantity(purchasedItem.getQuantity() + cartItem.getQuantity());
            }

            // Save the purchased item
            purchasedRepository.save(purchasedItem);
        }
        
        // Step 5: Clear the user's cart after successful checkout
        // (Assuming you have a method to clear the cart in CartService)
        cartService.clearCartByUserId(userId);
        
        logger.info("Checkout process completed for user with ID: {}", userId);
    }
}