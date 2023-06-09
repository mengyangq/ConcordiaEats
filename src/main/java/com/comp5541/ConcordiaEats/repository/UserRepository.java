package com.comp5541.ConcordiaEats.repository;

import com.comp5541.ConcordiaEats.model.User;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UserRepository extends JpaRepository<User, Integer> {

    @Query("SELECT u FROM User u")
    List<User> searchUsers();
	
    @Query("SELECT u FROM User u WHERE u.username = :username AND u.password = :password")
    User findByUsernameAndPassword(@Param("username") String username, @Param("password") String password);
    
    // Find user by username
    User findByUsername(String username);
    
    @Modifying
    @Query("DELETE FROM User WHERE username = :username")
    void deleteUsers(@Param("username")String username);
}
