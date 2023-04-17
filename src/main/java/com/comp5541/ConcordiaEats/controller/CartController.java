package com.comp5541.ConcordiaEats.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.comp5541.ConcordiaEats.service.CartService;
import com.comp5541.ConcordiaEats.model.CartItemInfo;

@Controller
@SessionAttributes("user_id")
public class CartController {
	@Autowired
	private CartService cartService;
	
	
	@GetMapping("/cart")
	public String showCartPage(@ModelAttribute("user_id") Integer userId, Model model) {
	    // Define the mapping of category IDs to category names
	    Map<Integer, String> categoryNames = new HashMap<>();
	    categoryNames.put(1, "Meals");
	    categoryNames.put(2, "Snacks");
	    categoryNames.put(3, "Fruits");
	    categoryNames.put(4, "Vegetables");
	    categoryNames.put(5, "Drinks");

	    // Add the mapping to the model
	    model.addAttribute("categoryNames", categoryNames);

	    // Get the list of cart items for the current user
	    List<CartItemInfo> cartItems = cartService.getCartItemsByUserId(userId);
	    model.addAttribute("cartItems", cartItems);

	    return "cart";
	}

	@PostMapping("/updateCartQuantity")
	@ResponseBody
	public ResponseEntity<String> updateCartQuantity(@RequestParam("userId") Integer userId,
			@RequestParam("productId") Integer productId, @RequestParam("newQuantity") Integer newQuantity) {
		try {
			// Call the service method to update the cart quantity
			cartService.updateCartQuantity(userId, productId, newQuantity);

			// Return a success response
			return ResponseEntity.ok("Cart quantity updated successfully.");
		} catch (Exception ex) {
			// Handle any exceptions and return an error response
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error updating cart quantity.");
		}
	}
	
	@PostMapping("/removeFromCart")
	public String removeFromCart(
	        @ModelAttribute("user_id") Integer userId,
	        @RequestParam("product_id") Integer productId,
	        RedirectAttributes redirectAttributes) {
	    try {
	        // Call the service method to remove the product from the cart
	        cartService.removeFromCart(userId, productId);

	        // Set success message and redirect to cart page
	        redirectAttributes.addFlashAttribute("successMessage", "Product removed from cart successfully.");
	        return "redirect:/cart"; // Update the URL to the cart page
	    } catch (Exception ex) {
	        // Set error message and redirect to cart page
	        redirectAttributes.addFlashAttribute("errorMessage", "Error removing product from cart.");
	        return "redirect:/cart"; // Update the URL to the cart page
	    }
	}

}
