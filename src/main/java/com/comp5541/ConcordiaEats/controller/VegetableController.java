package com.comp5541.ConcordiaEats.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import com.comp5541.ConcordiaEats.service.ProductService;
import java.util.List;
import com.comp5541.ConcordiaEats.model.Product;

@Controller
public class VegetableController {
	@Autowired
	private ProductService productService;

	@GetMapping("/category/vegetable")
	public String showMealPage(Model model) {
		// Retrieve products with categoryid = 1 (Meals)
		List<Product> vegetableProducts = productService.getProductsByCategoryId(4);
		model.addAttribute("vegetableProducts", vegetableProducts);
		return "category/vegetable";
	}

}
