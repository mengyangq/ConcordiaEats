package com.comp5541.ConcordiaEats.controller;

import com.comp5541.ConcordiaEats.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class RegisterController {
    @Autowired
    private UserService userService;
    
    // Handler for displaying the registration page
    @GetMapping("/register")
    public String showRegisterPage() {
        return "register";
    }
    
    // Handler for processing the registration form submission
    @PostMapping("/register")
    public String registerUser(
            @RequestParam("username") String username,
            @RequestParam("password") String password,
            @RequestParam("confirmPassword") String confirmPassword,
            @RequestParam("role") String role,
            @RequestParam("email") String email,
            Model model) {

        // Call the UserService to register a new user
        String result = userService.registerUser(username, password, confirmPassword, role, email);
        
        // Check the result of the registration process
        if ("User registered successfully.".equals(result)) {
            // Redirect to the login page if registration is successful
        	model.addAttribute("isSuccess", true);
            return "register";
        } else {
            // Display an error message if registration fails
            model.addAttribute("errorMessage", result);
            return "register";
        }
    }
}
