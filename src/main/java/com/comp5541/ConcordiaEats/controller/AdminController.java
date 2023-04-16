package com.comp5541.ConcordiaEats.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.comp5541.ConcordiaEats.model.User;
import com.comp5541.ConcordiaEats.service.UserService;

@Controller
@SessionAttributes("username")
public class AdminController {
	
	@GetMapping("/adminMain")
	public String showCustomerMainPage(@ModelAttribute("username") String username, Model model) {
	    if (username != null && !username.isEmpty()) {
	        return "adminMain";
	    }
	    return "admin";
	}
	
}
