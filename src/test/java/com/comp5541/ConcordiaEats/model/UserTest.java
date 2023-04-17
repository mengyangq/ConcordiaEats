package com.comp5541.ConcordiaEats.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class UserTest {
    private User user;

    @BeforeEach
    public void setUp() {
        // Initialize a new User object before each test
        user = new User();
    }

    @Test
    public void testUserId() {
        // Set a user ID and check if the getter returns the correct value
        user.setId(1);
        assertEquals(1, user.getId());
    }

    @Test
    public void testUsername() {
        // Set a username and check if the getter returns the correct value
        user.setUsername("testuser");
        assertEquals("testuser", user.getUsername());
    }

    @Test
    public void testPassword() {
        // Set a password and check if the getter returns the correct value
        user.setPassword("password123");
        assertEquals("password123", user.getPassword());
    }

    @Test
    public void testRole() {
        // Set a role and check if the getter returns the correct value
        user.setRole("ROLE_ADMIN");
        assertEquals("ROLE_ADMIN", user.getRole());
    }

    @Test
    public void testEnabled() {
        // Set the enabled status and check if the getter returns the correct value
        user.setEnabled(1);
        assertEquals(1, user.getEnabled());
    }

    @Test
    public void testEmail() {
        // Set an email address and check if the getter returns the correct value
        user.setEmail("test@example.com");
        assertEquals("test@example.com", user.getEmail());
    }
}
