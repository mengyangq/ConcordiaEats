package com.comp5541.ConcordiaEats.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;



@WebMvcTest(AdminController.class)
public class AdminControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testShowAdminMainPage_withUsername() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/admin/main")
                .sessionAttr("username", "admin"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.view().name("adminMain"));
    }

    @Test
    public void testShowAdminMainPage_withEmptyUsername() throws Exception {
        mockMvc.perform(get("/admin/main").sessionAttr("username", ""))
                .andExpect(status().isOk())
                .andExpect(view().name("login"));
    }
}
