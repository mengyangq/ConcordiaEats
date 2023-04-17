package com.comp5541.ConcordiaEats.repository;

import com.comp5541.ConcordiaEats.model.Category;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

//import org.springframework.data.repository.query.Param;
//import org.springframework.stereotype.Repository;
import java.util.List;


public interface CategoryRepository extends JpaRepository<Category, Integer> {
    
    @Query("SELECT c FROM Category c")
    List<Category> searchCategories();
}