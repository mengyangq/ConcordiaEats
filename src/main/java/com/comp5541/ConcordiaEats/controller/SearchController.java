package com.comp5541.ConcordiaEats.controller;

import com.comp5541.ConcordiaEats.model.Product;
import com.comp5541.ConcordiaEats.service.ProductService;
import com.comp5541.ConcordiaEats.repository.FavoriteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

//import org.springframework.web.bind.annotation.RequestParam;
import java.util.Map;
import java.util.HashMap;

import java.util.List;

@Controller
/*
 * public class SearchController {
 * 
 * @Autowired private ProductService productService;
 * 
 * @GetMapping("/search") public String showSearchPage(Model model,
 * 
 * @RequestParam(value = "productName", required = false) String productName,
 * 
 * @RequestParam(value = "minPrice", required = false) Double minPrice,
 * 
 * @RequestParam(value = "maxPrice", required = false) Double maxPrice) {
 * Map<Integer, String> categoryNames = new HashMap<>(); categoryNames.put(1,
 * "Meals"); categoryNames.put(2, "Snacks"); categoryNames.put(3, "Fruits");
 * categoryNames.put(4, "Vegetables"); categoryNames.put(5, "Drinks");
 * 
 * // Add the mapping to the model model.addAttribute("categoryNames",
 * categoryNames); // Retrieve products based on search criteria List<Product>
 * searchResults = productService.searchProducts(productName, minPrice,
 * maxPrice); model.addAttribute("searchResults", searchResults); return
 * "search"; }
 */
@SessionAttributes({"username", "user_id"})
public class SearchController {
	@Autowired
	private ProductService productService;
	
	@Autowired
	private FavoriteRepository favoriteRepository;

	@GetMapping("/search")
	public String showSearchPage(Model model,
			@ModelAttribute("username") String username,
            @ModelAttribute("user_id") Integer userId) {
		
		
		// Query the database for the list of product IDs that the user has already added to favorites
	    List<Integer> favoritedProductIds = favoriteRepository.findFavoritedProductIdsByUserId(userId);
	    
	    // Add the list of favorited product IDs to the model
	    model.addAttribute("favoritedProductIds", favoritedProductIds);
	    
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
		return "search";
	}
	
	@PostMapping("/addToFavorites")
    public String addToFavorites(
            @ModelAttribute("user_id") Integer userId,
            @RequestParam("product_id") Integer productId,
            RedirectAttributes redirectAttributes) {
        try {
            // Call the addProductToFavorites function to insert data to favorites table
            productService.addProductToFavorites(userId, productId);

            // Set success message and redirect to search page
            redirectAttributes.addFlashAttribute("successMessage", "Product added to favorites successfully.");
            return "redirect:/search";
        } catch (Exception ex) {
            // Set error message and redirect to search page
            redirectAttributes.addFlashAttribute("errorMessage", "Error adding product to favorites.");
            return "redirect:/search";
        }
    }

}
