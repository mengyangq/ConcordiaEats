package com.comp5541.ConcordiaEats.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.comp5541.ConcordiaEats.model.Product;
import com.comp5541.ConcordiaEats.service.ProductService;


@Controller
public class AdminSellingController {
	@Autowired
	private ProductService productService;
	
	@GetMapping("/admin/selling")
    public String showAdminProductsPage(Model model) {
		Map<Integer, String> categoryNames = new HashMap<>();
		categoryNames.put(1, "Meals");
		categoryNames.put(2, "Snacks");
		categoryNames.put(3, "Fruits");
		categoryNames.put(4, "Vegetables");
		categoryNames.put(5, "Drinks");
		
		model.addAttribute("categoryNames", categoryNames);
		
		List<Product> products = productService.searchSelling();
		model.addAttribute("products", products);
		
        return "adminSelling";
    }
}