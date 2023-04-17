package com.comp5541.ConcordiaEats.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.comp5541.ConcordiaEats.service.ProductService;
import java.util.List;

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
	public String updateProducts(@RequestParam("name") String name,@RequestParam("id") Integer id) {

	    return "redirect:/admin/products";
	}
	
	@PostMapping("/admin/insertProducts")
	public String insertProducts() {
		
		
		return "redirect:/admin/products";
	}
}