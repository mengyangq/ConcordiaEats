package com.comp5541.ConcordiaEats.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;


@SpringBootTest
@AutoConfigureMockMvc
public class CustomerControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testShowCustomerMainPage_withValidUsername() throws Exception {
        mockMvc.perform(get("/main").sessionAttr("username", "john_doe"))
                .andExpect(status().isOk())
                .andExpect(view().name("customerMain"));
    }

    @Test
    public void testShowCustomerMainPage_withEmptyUsername() throws Exception {
        mockMvc.perform(get("/main").sessionAttr("username", ""))
                .andExpect(status().isOk())
                .andExpect(view().name("login"));
    }

}
