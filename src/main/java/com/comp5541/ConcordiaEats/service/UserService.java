package com.comp5541.ConcordiaEats.service;

import java.util.List;

import com.comp5541.ConcordiaEats.model.User;

public interface UserService {
	
	List<User> searchUsers();
	
    User findByUsernameAndPassword(String username, String password);
    
    String registerUser(String username, String password, String confirmPassword, String role, String email);
    
    void deleteUsers(String username);
}
