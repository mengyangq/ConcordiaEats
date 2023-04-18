package com.comp5541.ConcordiaEats.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;
import com.comp5541.ConcordiaEats.service.RecommendationService;
import com.comp5541.ConcordiaEats.service.RecommendationService.RecommendedProduct;

@Controller
@SessionAttributes({"username", "user_id"}) // Specify the session attribute names
public class CustomerController {

    @Autowired
    private RecommendationService recommendationService;

    @GetMapping("/main")
    public String showCustomerMainPage(@ModelAttribute("username") String username, 
                                       @ModelAttribute("user_id") Integer userId, Model model) {
        if (username != null && !username.isEmpty()) {
            // Get the recommended products using the RecommendationService
            List<RecommendedProduct> recommendedProducts = recommendationService.getRecommendations(userId);

            // Add the recommended products to the model
            model.addAttribute("recommendedProducts", recommendedProducts);

            return "customerMain";
        }
        return "login";
    }
}