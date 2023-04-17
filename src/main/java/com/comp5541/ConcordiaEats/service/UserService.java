package com.comp5541.ConcordiaEats.service;

import com.comp5541.ConcordiaEats.model.User;

public interface UserService {
    User findByUsernameAndPassword(String username, String password);
    
    String registerUser(String username, String password, String confirmPassword, String role, String email);
}
