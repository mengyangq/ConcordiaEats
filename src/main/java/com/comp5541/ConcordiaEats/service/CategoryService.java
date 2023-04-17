package com.comp5541.ConcordiaEats.service;
import com.comp5541.ConcordiaEats.model.Category;
import com.comp5541.ConcordiaEats.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class CategoryService {
    @Autowired
    private CategoryRepository categoryRepository;
    
    // Simplified method to retrieve all products
    public List<Category> searchCategories() {
        return categoryRepository.searchCategories();
    }
}
