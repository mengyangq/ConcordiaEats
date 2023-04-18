package com.comp5541.ConcordiaEats.controller;

import com.comp5541.ConcordiaEats.model.Product;
import com.comp5541.ConcordiaEats.service.FavoriteService;
import com.comp5541.ConcordiaEats.service.CartService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@ExtendWith(MockitoExtension.class)
public class FavoriteControllerTest {
    @InjectMocks
    private FavoriteController favoriteController;

    @Mock
    private FavoriteService favoriteService;

    @Mock
    private CartService cartService;

    private MockMvc mockMvc;

    @BeforeEach
    public void setup() {
        mockMvc = MockMvcBuilders.standaloneSetup(favoriteController).build();
    }

    @Test
    public void testRemoveFromFavorites() throws Exception {
        mockMvc.perform(post("/removeFromFavorites")
                .sessionAttr("user_id", 1)
                .param("product_id", "100"))
                .andExpect(status().is3xxRedirection())
                .andExpect(flash().attribute("successMessage", "Product removed from favorites successfully."))
                .andExpect(redirectedUrl("/favorites"));
    }

    @Test
    public void testAddToCartF() throws Exception {
        mockMvc.perform(post("/addToCartF")
                .sessionAttr("user_id", 1)
                .param("product_id", "100")
                .param("quantity", "1"))
                .andExpect(status().is3xxRedirection())
                .andExpect(flash().attribute("successMessage", "Product added to cart successfully."))
                .andExpect(redirectedUrl("/favorites"));
    }
}
