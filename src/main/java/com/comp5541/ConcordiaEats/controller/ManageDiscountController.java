package com.comp5541.ConcordiaEats.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.comp5541.ConcordiaEats.service.ProductService;

@Controller
@SessionAttributes("username")
public class ManageDiscountController {
	@Autowired
	private ProductService productService;
	
	@PostMapping("/admin/resetDiscount")
	public String resetDiscount(@RequestParam("id") Integer id) {
		
		productService.resetDiscount(id);
	    return "redirect:/admin/discounts";
	}
	
	@PostMapping("/admin/applyDiscount")
	public String updateDiscount(@RequestParam("discount") Integer discount, @RequestParam("id") Integer id) {
		
		productService.updateDiscount(discount, id);
	    return "redirect:/admin/discounts";
	}
}
