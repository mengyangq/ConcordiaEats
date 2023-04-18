package com.comp5541.ConcordiaEats.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.comp5541.ConcordiaEats.model.Product;
import com.comp5541.ConcordiaEats.service.ProductService;

@Controller
public class MealController {
	@Autowired
	private ProductService productService;

	@GetMapping("/category/meal")
	public String showMealPage(Model model) {
		// Retrieve products with categoryid = 1 (Meals)
		List<Product> mealProducts = productService.getProductsByCategoryId(1);
		model.addAttribute("mealProducts", mealProducts);
		return "category/meal";
	}
}
