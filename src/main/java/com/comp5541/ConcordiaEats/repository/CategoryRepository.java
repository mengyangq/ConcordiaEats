package com.comp5541.ConcordiaEats.repository;

import com.comp5541.ConcordiaEats.model.Category;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

//import org.springframework.data.repository.query.Param;
//import org.springframework.stereotype.Repository;
import java.util.List;

import javax.transaction.Transactional;


public interface CategoryRepository extends JpaRepository<Category, Integer> {
    
	
    @Query("SELECT c FROM Category c")
    List<Category> searchCategories();
    
    
    @Modifying
    @Query("DELETE FROM Category WHERE categoryid = :categoryid")
    void deleteCategory(@Param("categoryid")Integer categoryid);
    
    @Modifying
    @Query("UPDATE Category SET name = :name WHERE categoryid = :categoryid")
    void updateCategory(@Param("name")String name, @Param("categoryid")Integer categoryid);
    
    @Modifying
    @Query(value = "INSERT INTO categories (name) VALUES (:name)", nativeQuery = true)
    void insertCategory(@Param("name") String name);
    
}