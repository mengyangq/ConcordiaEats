package com.comp5541.ConcordiaEats.service;
import com.comp5541.ConcordiaEats.model.Product;
import com.comp5541.ConcordiaEats.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    public List<Product> getProductsByCategoryId(Integer categoryId) {
        return productRepository.findByCategoryid(categoryId);
    }
    
    public List<Product> searchProducts(String productName, Double minPrice, Double maxPrice) {
        // Call the custom method in the ProductRepository to search for products based on the criteria
        return productRepository.searchProducts(productName, minPrice, maxPrice);
    }
}
