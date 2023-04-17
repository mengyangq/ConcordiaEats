package com.comp5541.ConcordiaEats.service;

import com.comp5541.ConcordiaEats.model.User;
import com.comp5541.ConcordiaEats.repository.UserRepository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public List<User> searchUsers() {
        return userRepository.searchUsers();
    }
    
    @Override
    public User findByUsernameAndPassword(String username, String password) {
        return userRepository.findByUsernameAndPassword(username, password);
    }
    
    @Override
    public String registerUser(String username, String password, String confirmPassword, String role, String email) {
        // Check if username already exists
        User existingUser = userRepository.findByUsername(username);
        if (existingUser != null) {
            return "Username already exists.";
        }
        // Check if passwords match
        if (!password.equals(confirmPassword)) {
            return "Passwords do not match.";
        }
        // Create new user
        User newUser = new User();
        newUser.setUsername(username);
        newUser.setPassword(password);
        newUser.setRole(role);
        newUser.setEnabled(1);
        newUser.setEmail(email);
        userRepository.save(newUser);
        return "User registered successfully.";
    }
    
    @Override
	public void deleteUsers(String username) {
    	userRepository.deleteUsers(username);
    }
}
