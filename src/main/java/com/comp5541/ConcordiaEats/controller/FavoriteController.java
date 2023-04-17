package com.comp5541.ConcordiaEats.controller;

import com.comp5541.ConcordiaEats.model.Product;
import com.comp5541.ConcordiaEats.service.FavoriteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@SessionAttributes("user_id")
public class FavoriteController {
    @Autowired
    private FavoriteService favoriteService;

    @GetMapping("/favorites")
    public String showFavoritesPage(@ModelAttribute("user_id") Integer user_id, Model model) {
    	
    	
    	Map<Integer, String> categoryNames = new HashMap<>();
		categoryNames.put(1, "Meals");
		categoryNames.put(2, "Snacks");
		categoryNames.put(3, "Fruits");
		categoryNames.put(4, "Vegetables");
		categoryNames.put(5, "Drinks");

		// Add the mapping to the model
		model.addAttribute("categoryNames", categoryNames);
		
        List<Product> favoriteProducts = favoriteService.getFavoriteProductsByUserId(user_id);
        model.addAttribute("favoriteProducts", favoriteProducts);
        return "favorites";
    }
    
    @PostMapping("/removeFromFavorites")
    public String removeFromFavorites(
            @ModelAttribute("user_id") Integer userId,
            @RequestParam("product_id") Integer productId,
            RedirectAttributes redirectAttributes) {
        try {
            // Call the removeProductFromFavorites function to remove data from favorites table
            favoriteService.removeProductFromFavorites(userId, productId);

            // Set success message and redirect to favorites page
            redirectAttributes.addFlashAttribute("successMessage", "Product removed from favorites successfully.");
            return "redirect:/favorites";
        } catch (Exception ex) {
            // Set error message and redirect to favorites page
            redirectAttributes.addFlashAttribute("errorMessage", "Error removing product from favorites.");
            return "redirect:/favorites";
        }
    }

}
