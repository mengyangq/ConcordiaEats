package com.comp5541.ConcordiaEats.service;
import com.comp5541.ConcordiaEats.model.Category;
import com.comp5541.ConcordiaEats.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class CategoryService {
    @Autowired
    private CategoryRepository categoryRepository;
    
    // Simplified method to retrieve all products
    public List<Category> searchCategories() {
        return categoryRepository.searchCategories();
    }
    
    public void deleteCategory(Integer categoryid) {
    	try {
            categoryRepository.deleteCategory(categoryid);
        } catch (Exception e) {
            System.err.println("Error deleting category: " + e.getMessage());
        }
    }
    
    public void updateCategory(String name, Integer categoryid) {
        categoryRepository.updateCategory(name, categoryid);
    };
}
