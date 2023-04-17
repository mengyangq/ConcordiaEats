package com.comp5541.ConcordiaEats.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.comp5541.ConcordiaEats.model.Category;
import com.comp5541.ConcordiaEats.model.Product;
import com.comp5541.ConcordiaEats.service.CategoryService;
import com.comp5541.ConcordiaEats.service.ProductService;

@Controller
public class AdminCategoriesController {
    
	@Autowired
	private CategoryService categoryService;
	
	@GetMapping("/admin/categories")
    public String showAdminCategoriesPage(Model model) {
		// Retrieve categories
		List<Category> categories = categoryService.searchCategories();
		model.addAttribute("categories", categories);
		
        return "adminCategories";
    }
}
