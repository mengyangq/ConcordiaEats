package com.comp5541.ConcordiaEats.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.comp5541.ConcordiaEats.repository.CartRepository;
import com.comp5541.ConcordiaEats.model.*;

@Service
public class CartService {
    @Autowired
    private CartRepository cartRepository;

    public void addProductToCart(Integer userId, Integer productId, Integer quantity) {
        // Create a new Cart instance
        Cart cart = new Cart();
        
        // Create a new CartId instance
        Cart.CartId cartId = new Cart.CartId();
        cartId.setUser_id(userId);
        cartId.setProduct_id(productId);
        
        // Set the CartId to the Cart instance
        cart.setId(cartId);
        
        // Set the quantity
        cart.setQuantity(quantity);

        // Save the new cart item to the cart table
        cartRepository.save(cart);
    }
    
    public void updateCartQuantity(Integer userId, Integer productId, Integer newQuantity) {
        // Get the Cart instance based on the composite key (userId, productId)
    	Cart.CartId cartId = new Cart.CartId();
        cartId.setUser_id(userId);
        cartId.setProduct_id(productId);
        Cart cart = cartRepository.findById(cartId).orElse(null);

        // If the cart item exists, update the quantity
        if (cart != null) {
            cart.setQuantity(newQuantity);
            cartRepository.save(cart); // Save the updated cart item
        }
    }
    
    public void removeFromCart(Integer userId, Integer productId) {
        // Create a CartId instance based on the composite key (userId, productId)
    	Cart.CartId cartId = new Cart.CartId();
        cartId.setUser_id(userId);
        cartId.setProduct_id(productId);

        // Delete the cart item based on the CartId
        cartRepository.deleteById(cartId);
    }
    
    public List<CartItemInfo> getCartItemsByUserId(Integer userId) {
        // Use the CartRepository to retrieve the cart items for the specific user
        List<CartItemInfo> cartItems = cartRepository.findCartItemsByUserId(userId);
        return cartItems;
    }
    
    public void clearCartByUserId(Integer userId) {
        // Delete all cart items based on the user ID
        cartRepository.deleteByUserId(userId);
    }
}
