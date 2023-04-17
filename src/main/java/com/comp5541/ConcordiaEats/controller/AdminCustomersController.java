package com.comp5541.ConcordiaEats.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.comp5541.ConcordiaEats.model.User;
import com.comp5541.ConcordiaEats.service.UserService;

@Controller
public class AdminCustomersController {
	@Autowired
	private UserService userService;
	
	@GetMapping("/admin/customers")
	public String showAdminCustomersPage(Model model) {
		
		List<User> users = userService.searchUsers();
		model.addAttribute("users", users);
		
        return "adminCustomers";
    }
	
}
