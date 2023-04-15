package com.comp5541.ConcordiaEats.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import com.comp5541.ConcordiaEats.service.ProductService;
import java.util.List;
import com.comp5541.ConcordiaEats.model.Product;

@Controller
public class FruitController {
	@Autowired
	private ProductService productService;

	@GetMapping("/category/fruit")
	public String showMealPage(Model model) {
		// Retrieve products with categoryid = 1 (Meals)
		List<Product> fruitProducts = productService.getProductsByCategoryId(3);
		model.addAttribute("fruitProducts", fruitProducts);
		return "category/fruit";
	}

}
