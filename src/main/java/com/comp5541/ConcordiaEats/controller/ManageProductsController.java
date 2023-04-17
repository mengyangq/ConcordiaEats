package com.comp5541.ConcordiaEats.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.comp5541.ConcordiaEats.model.Product;
import com.comp5541.ConcordiaEats.service.ProductService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@SessionAttributes("username")
public class ManageProductsController {
	@Autowired
	private ProductService productService;
	
	@PostMapping("/admin/deleteProducts")
	public String deleteProducts(@RequestParam("id") Integer id) {
		// System.out.println("id = " + id);
		productService.deleteProduct(id);
	    return "redirect:/admin/products";
	}

	@PostMapping("/admin/updateProducts")
	public String updateProducts(@Param("id")Integer id,
			@Param("name") String name,
    		@Param("categoryid")Integer categoryid, 
    		@Param("quantity")Integer quantity, 
    		@Param("price")Double price, 
    		@Param("weight")Integer weight, 
    		@Param("description")String description, 
    		@Param("image")String image,
    		Model model) {
		
		if (image == null || image == ""){
			String temp = "https://placehold.co/100x100.png";
			image = temp;
		}
		
		Map<Integer, String> categoryNames = new HashMap<>();
		categoryNames.put(1, "Meals");
		categoryNames.put(2, "Snacks");
		categoryNames.put(3, "Fruits");
		categoryNames.put(4, "Vegetables");
		categoryNames.put(5, "Drinks");
		
		model.addAttribute("categoryNames", categoryNames);
		
		try {
			productService.updateProduct(id, name, categoryid, quantity, 
	        		price, weight, description, image);
			model.addAttribute("message", "Woo-Hoo: Product has been successfully updated!");
			
			List<Product> products = productService.searchProducts();
			model.addAttribute("products", products);
			
			return "adminProducts";
		} catch (Exception ex) {
			model.addAttribute("errorMessage", "Error: product with same name already exists!");
			return "adminUpdateProducts";
		}
	}
	
	@PostMapping("/admin/insertProducts")
	public String insertProducts(@Param("name") String name,
    		@Param("categoryid")Integer categoryid, 
    		@Param("quantity")Integer quantity, 
    		@Param("price")Double price, 
    		@Param("weight")Integer weight, 
    		@Param("description")String description, 
    		@Param("image")String image,
    		Model model) {
		
		if (image == null || image == ""){
			String temp = "https://placehold.co/100x100.png";
			image = temp;
		}
		
		Map<Integer, String> categoryNames = new HashMap<>();
		categoryNames.put(1, "Meals");
		categoryNames.put(2, "Snacks");
		categoryNames.put(3, "Fruits");
		categoryNames.put(4, "Vegetables");
		categoryNames.put(5, "Drinks");
		
		model.addAttribute("categoryNames", categoryNames);
		
		try {
			productService.insertProduct(name, categoryid, quantity, 
	        		price, weight, description, image);
			model.addAttribute("message", "Woo-Hoo: Product has been successfully inserted!");
			
			List<Product> products = productService.searchProducts();
			model.addAttribute("products", products);
			
			return "adminProducts";
		} catch (Exception ex) {
			model.addAttribute("errorMessage", "Error: product with same name already exists!");
			return "adminInsertProducts";
		}	
	}
}