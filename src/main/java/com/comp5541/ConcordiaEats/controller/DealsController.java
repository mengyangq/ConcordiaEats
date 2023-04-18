package com.comp5541.ConcordiaEats.controller;

import java.util.HashMap;
import java.util.List;
//import org.springframework.web.bind.annotation.RequestParam;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.comp5541.ConcordiaEats.model.Product;
import com.comp5541.ConcordiaEats.repository.CartRepository;
import com.comp5541.ConcordiaEats.repository.FavoriteRepository;
import com.comp5541.ConcordiaEats.service.CartService;
import com.comp5541.ConcordiaEats.service.ProductService;

@Controller
@SessionAttributes({"username", "user_id"})
public class DealsController {
	@Autowired
	private ProductService productService;
	
	@Autowired
	private CartService cartService;
	
	@Autowired
	private FavoriteRepository favoriteRepository;
	
	@Autowired
	private CartRepository cartRepository;

	@GetMapping("/deals")
	public String showSearchPage(Model model,
			@ModelAttribute("username") String username,
            @ModelAttribute("user_id") Integer userId) {
		
		
		// Query the database for the list of product IDs that the user has already added to favorites
	    List<Integer> favoritedProductIds = favoriteRepository.findFavoritedProductIdsByUserId(userId);
	    
	 // Get the list of product IDs that the user has already added to cart
	    List<Integer> productIdsInCart = cartRepository.findProductIdsInCartByUserId(userId);

	    
	    // Add the list of favorited product IDs to the model
	    model.addAttribute("favoritedProductIds", favoritedProductIds);
	    
	 // Add the list of product IDs in the cart to the model
	    model.addAttribute("productIdsInCart", productIdsInCart);
	    
		Map<Integer, String> categoryNames = new HashMap<>();
		categoryNames.put(1, "Meals");
		categoryNames.put(2, "Snacks");
		categoryNames.put(3, "Fruits");
		categoryNames.put(4, "Vegetables");
		categoryNames.put(5, "Drinks");

		// Add the mapping to the model
		model.addAttribute("categoryNames", categoryNames);

		// Call the simplified searchProducts method to retrieve all products
		List<Product> searchResults = productService.searchProducts();
		model.addAttribute("searchResults", searchResults);
		return "deals";
	}
	
	@PostMapping("/addToFavoritesD")
    public String addToFavorites(
            @ModelAttribute("user_id") Integer userId,
            @RequestParam("product_id") Integer productId,
            RedirectAttributes redirectAttributes) {
        try {
            // Call the addProductToFavorites function to insert data to favorites table
            productService.addProductToFavorites(userId, productId);

            // Set success message and redirect to search page
            redirectAttributes.addFlashAttribute("successMessage", "Product added to favorites successfully.");
            return "redirect:/deals";
        } catch (Exception ex) {
            // Set error message and redirect to search page
            redirectAttributes.addFlashAttribute("errorMessage", "Error adding product to favorites.");
            return "redirect:/deals";
        }
    }
	
	@PostMapping("/addToCartD")
	public String addToCart(
	        @ModelAttribute("user_id") Integer userId,
	        @RequestParam("product_id") Integer productId,
	        @RequestParam("quantity") Integer quantity,
	        RedirectAttributes redirectAttributes) {
	    try {
	        // Call the addProductToCart function to insert data into the cart table
	        cartService.addProductToCart(userId, productId, quantity);

	        // Set success message and redirect to the search page
	        redirectAttributes.addFlashAttribute("successMessage", "Product added to cart successfully.");
	        return "redirect:/deals";
	    } catch (Exception ex) {
	        // Set error message and redirect to the search page
	        redirectAttributes.addFlashAttribute("errorMessage", "Error adding product to cart.");
	        return "redirect:/deals";
	    }
	}

}
