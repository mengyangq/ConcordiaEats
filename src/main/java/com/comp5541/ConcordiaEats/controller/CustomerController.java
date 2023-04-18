package com.comp5541.ConcordiaEats.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.comp5541.ConcordiaEats.service.RecommendationService;
import com.comp5541.ConcordiaEats.service.RecommendationService.RecommendedProduct;
import com.comp5541.ConcordiaEats.service.*;
import com.comp5541.ConcordiaEats.model.*;

@Controller
@SessionAttributes({"username", "user_id"}) // Specify the session attribute names
public class CustomerController {

    @Autowired
    private RecommendationService recommendationService;
    
    @Autowired
    private CartService cartService;

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
    
    @PostMapping("/addToCartR")
    public String addToCart(
            @ModelAttribute("user_id") Integer userId,
            @RequestParam("product_id") Integer productId,
            @RequestParam("quantity") Integer quantity,
            RedirectAttributes redirectAttributes) {
        try {
            // Check if the product is already in the cart
            Cart cartItem = cartService.findCartItemByUserIdAndProductId(userId, productId);
            if (cartItem == null) {
                // Add the product to the cart if it's not already in the cart
                cartService.addProductToCart(userId, productId, quantity);
                // Set success message
                redirectAttributes.addFlashAttribute("successMessage", "Product added to cart successfully.");
            } else {
                // Set message indicating that the product is already in the cart
                redirectAttributes.addFlashAttribute("infoMessage", "Product is already in the cart.");
            }
            // Redirect to the cart page
            return "redirect:/cart";
        } catch (Exception ex) {
            // Set error message and redirect to the search page
            redirectAttributes.addFlashAttribute("errorMessage", "Error adding product to cart.");
            return "redirect:/main";
        }
    }
    
}