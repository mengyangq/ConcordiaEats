package com.comp5541.ConcordiaEats.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes("username") // Specify the session attribute names
public class CustomerController {
	@GetMapping("/customerMain")
	public String showCustomerMainPage(@ModelAttribute("username") String username, Model model) {
	    if (username != null && !username.isEmpty()) {
	        return "customerMain";
	    }
	    return "login";
	}
}
