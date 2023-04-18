package com.comp5541.ConcordiaEats.controller;


import com.comp5541.ConcordiaEats.repository.CartRepository;
import com.comp5541.ConcordiaEats.repository.FavoriteRepository;
import com.comp5541.ConcordiaEats.service.CartService;
import com.comp5541.ConcordiaEats.service.ProductService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;



import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.redirectedUrl;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;



@WebMvcTest(SearchController.class)
public class SearchControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ProductService productService;

    @MockBean
    private CartService cartService;

    @MockBean
    private FavoriteRepository favoriteRepository;

    @MockBean
    private CartRepository cartRepository;

   
    @Test
    public void testAddToFavorites() throws Exception {
        mockMvc.perform(post("/addToFavorites")
                .sessionAttr("user_id", 1)
                .param("product_id", "1"))
                .andExpect(status().is3xxRedirection())
                .andExpect(redirectedUrl("/search"))
                .andExpect(model().attributeDoesNotExist("errorMessage"));  // Expect no error message
    }

    @Test
    public void testAddToCart() throws Exception {
        mockMvc.perform(post("/addToCart")
                .sessionAttr("user_id", 1)
                .param("product_id", "1")
                .param("quantity", "1"))
                .andExpect(status().is3xxRedirection())
                .andExpect(redirectedUrl("/search"))
                .andExpect(model().attributeDoesNotExist("errorMessage"));  // Expect no error message
    }
}

