package com.comp5541.ConcordiaEats.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.comp5541.ConcordiaEats.service.CategoryService;
import java.util.List;

@Controller
@SessionAttributes("username")
public class ManageCategoriesController {
	
	@Autowired
	private CategoryService categoryService;
	
	@PostMapping("/admin/deleteCategories")
	public String deleteCategories(@RequestParam("categoryid") Integer categoryid) {
		// System.out.println("categoryid = " + categoryid);
	    categoryService.deleteCategory(categoryid);
	    return "redirect:/admin/categories";
	}

	@PostMapping("/admin/updateCategories")
	public String updateCategories(@RequestParam("categoryname") String categoryname,@RequestParam("categoryid") Integer categoryid) {
		// System.out.println("categoryid = " + categoryid);
		// System.out.println("categoryname = " + categoryname);
	    categoryService.updateCategory(categoryname, categoryid);
	    return "redirect:/admin/categories";
	}
	
	@PostMapping("/admin/insertCategories")
	public String insertCategories(@RequestParam("categoryname") String categoryname) {
		
		categoryService.insertCategory(categoryname);
		
		return "redirect:/admin/categories";
	}
}
