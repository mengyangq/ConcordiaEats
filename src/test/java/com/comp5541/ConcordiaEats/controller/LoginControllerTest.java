package com.comp5541.ConcordiaEats.controller;

import com.comp5541.ConcordiaEats.controller.LoginController;
import com.comp5541.ConcordiaEats.model.User;
import com.comp5541.ConcordiaEats.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


@SuppressWarnings("unused")
@WebMvcTest(LoginController.class)
public class LoginControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private UserService userService;

    @Test
    public void testSuccessfulLoginAsAdmin() throws Exception {
        User adminUser = new User();
        adminUser.setUsername("admin");
        adminUser.setPassword("admin123");
        adminUser.setRole("ROLE_ADMIN");

        when(userService.findByUsernameAndPassword("admin", "admin123")).thenReturn(adminUser);

        mockMvc.perform(post("/login")
                .param("username", "admin")
                .param("password", "admin123"))
                .andExpect(status().is3xxRedirection())
                .andExpect(redirectedUrl("/admin"));
    }

    @Test
    public void testSuccessfulLoginAsCustomer() throws Exception {
        User customerUser = new User();
        customerUser.setUsername("customer");
        customerUser.setPassword("cust123");
        customerUser.setRole("ROLE_CUSTOMER");

        when(userService.findByUsernameAndPassword("customer", "cust123")).thenReturn(customerUser);

        mockMvc.perform(post("/login")
                .param("username", "customer")
                .param("password", "cust123"))
                .andExpect(status().is3xxRedirection())
                .andExpect(redirectedUrl("/customerMain"));
    }

    @Test
    public void testFailedLogin() throws Exception {
        when(userService.findByUsernameAndPassword("invalidUser", "invalidPass")).thenReturn(null);

        mockMvc.perform(post("/login")
                .param("username", "invalidUser")
                .param("password", "invalidPass"))
                .andExpect(status().isOk())
                .andExpect(view().name("login"))
                .andExpect(model().attribute("errorMessage", "Invalid username or password."));
    }
}