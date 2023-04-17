package com.comp5541.ConcordiaEats.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import com.comp5541.ConcordiaEats.service.ProductService;
import java.util.List;
import com.comp5541.ConcordiaEats.model.Product;

@Controller
public class ManageCategoriesController {
	
	@Autowired
	private ProductService productService;

	@PostMapping("/admin/addCategories")
	public String addCategories(Model model) {
		
		return;
	}
	
	@PostMapping("/admin/updateCategories")
	public String updateCategories(Model model) {
		
		return;
	}
	
	@PostMapping("/admin/deleteCategories")
	public String deleteCategories(Model model) {
		
		return;
	}
}
