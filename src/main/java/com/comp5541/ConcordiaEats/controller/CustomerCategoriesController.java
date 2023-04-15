package com.comp5541.ConcordiaEats.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CustomerCategoriesController {
    @GetMapping("/customerCategories")
    public String showCustomerCategoriesPage(Model model) {
        // Add any additional data to the model if needed.
        // For example, you can add a list of categories to display on the page.

        // Return the view name for the customerCategories page
        return "customerCategories";
    }
}