package com.comp5541.ConcordiaEats.controller;

import com.comp5541.ConcordiaEats.controller.RegisterController;
import com.comp5541.ConcordiaEats.service.UserService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

@ExtendWith(SpringExtension.class)
@WebMvcTest(RegisterController.class)
public class RegisterControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private UserService userService;

    @Test
    public void testShowRegisterPage() throws Exception {
        mockMvc.perform(get("/register"))
                .andExpect(status().isOk())
                .andExpect(view().name("register"));
    }

    @Test
    public void testRegisterUser_Success() throws Exception {
        when(userService.registerUser(anyString(), anyString(), anyString(), anyString(), anyString()))
                .thenReturn("User registered successfully.");

        mockMvc.perform(post("/register")
                .param("username", "testuser")
                .param("password", "testpass")
                .param("confirmPassword", "testpass")
                .param("role", "ROLE_USER")
                .param("email", "test@email.com"))
                .andExpect(status().isOk())
                .andExpect(model().attribute("isSuccess", true))
                .andExpect(view().name("register"));
    }

    @Test
    public void testRegisterUser_Failure() throws Exception {
        when(userService.registerUser(anyString(), anyString(), anyString(), anyString(), anyString()))
                .thenReturn("Error: Passwords do not match.");

        mockMvc.perform(post("/register")
                .param("username", "testuser")
                .param("password", "testpass")
                .param("confirmPassword", "wrongpass")
                .param("role", "ROLE_USER")
                .param("email", "test@email.com"))
                .andExpect(status().isOk())
                .andExpect(model().attribute("errorMessage", "Error: Passwords do not match."))
                .andExpect(view().name("register"));
    }
}
