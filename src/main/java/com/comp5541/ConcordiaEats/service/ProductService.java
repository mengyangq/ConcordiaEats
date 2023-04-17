package com.comp5541.ConcordiaEats.service;
import com.comp5541.ConcordiaEats.model.Product;
import com.comp5541.ConcordiaEats.repository.ProductRepository;
import com.comp5541.ConcordiaEats.model.Favorite;
import com.comp5541.ConcordiaEats.repository.FavoriteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;
    
    @Autowired
    private FavoriteRepository favoriteRepository;

    public List<Product> getProductsByCategoryId(Integer categoryId) {
        return productRepository.findByCategoryid(categoryId);
    }
    
    /*public List<Product> searchProducts(String productName, Double minPrice, Double maxPrice) {
        // Call the custom method in the ProductRepository to search for products based on the criteria
        return productRepository.searchProducts(productName, minPrice, maxPrice);
    }*/
    
 // Simplified method to retrieve all products
    public List<Product> searchProducts() {
        return productRepository.searchProducts();
    }
    
    public void addProductToFavorites(Integer userId, Integer productId) {
        // Create a new Favorite instance
        Favorite favorite = new Favorite();
        Favorite.FavoriteId id = new Favorite.FavoriteId();
        id.setUser_id(userId);
        id.setProduct_id(productId);
        favorite.setId(id);

        // Save the new favorite to the favorites table
        favoriteRepository.save(favorite);
    }
    
}
