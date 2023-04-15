package com.comp5541.ConcordiaEats.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import com.comp5541.ConcordiaEats.service.ProductService;
import java.util.List;
import com.comp5541.ConcordiaEats.model.Product;

@Controller
public class DrinkController {
	@Autowired
	private ProductService productService;

	@GetMapping("/category/drink")
	public String showDrinkPage(Model model) {
		// Retrieve products with categoryid = 5 (Drinks)
		List<Product> drinkProducts = productService.getProductsByCategoryId(5);
		model.addAttribute("drinkProducts", drinkProducts);
		return "category/drink";
	}

}
