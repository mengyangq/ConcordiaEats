package com.comp5541.ConcordiaEats.controller;

import com.comp5541.ConcordiaEats.model.User;
import com.comp5541.ConcordiaEats.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
//import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@SessionAttributes("username")
public class LoginController {
    @Autowired
    private UserService userService;
    
    // Handler for displaying the login page
    @GetMapping({"/", "/login"})
    public String showLoginPage() {
        return "login";
    }

    @PostMapping("/login")
    public String loginUser(@RequestParam("username") String username,
                            @RequestParam("password") String password,
                            Model model) {
        User user = userService.findByUsernameAndPassword(username, password);
        if (user != null) {
            // Check the role of the authenticated user
            String role = user.getRole();
            if ("ROLE_ADMIN".equals(role)) {
                // Redirect to admin.html if the user is an admin
                return "redirect:/admin";
            } else {
                // Set the username as a session attribute
                model.addAttribute("username", username);
                // Redirect to customerMain.html if the user is a customer
                return "redirect:/customerMain";
            }
        } else {
            // Handle the case when authentication fails (e.g., show an error message)
            model.addAttribute("errorMessage", "Invalid username or password.");
            return "login"; // Return to the login page
        }
    }

}
