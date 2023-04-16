package com.comp5541.ConcordiaEats.controller;

import com.comp5541.ConcordiaEats.model.Product;
import com.comp5541.ConcordiaEats.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
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
public class SearchController {
	@Autowired
	private ProductService productService;

	@GetMapping("/search")
	public String showSearchPage(Model model) {
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

}
