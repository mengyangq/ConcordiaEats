package com.comp5541.ConcordiaEats.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.comp5541.ConcordiaEats.service.UserService;
import java.util.List;

@Controller
@SessionAttributes("username")
public class ManageCustomersController {
	@Autowired
	private UserService userService;
	
	@PostMapping("/admin/deleteUsers")
	public String deleteUsers(@RequestParam("username") String username) {
		
	    userService.deleteUsers(username);
	    return "redirect:/admin/customers";
	}
}