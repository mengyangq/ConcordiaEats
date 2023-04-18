package com.comp5541.ConcordiaEats.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.comp5541.ConcordiaEats.model.Favorite;
import com.comp5541.ConcordiaEats.model.Product;
import com.comp5541.ConcordiaEats.repository.FavoriteRepository;
import com.comp5541.ConcordiaEats.repository.ProductRepository;

@Service
@Transactional
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
    
    public Product searchProducts(Integer id) {
    	return productRepository.searchProducts(id);
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

    public void deleteProduct(Integer id) {
    	productRepository.deleteProduct(id);
    }
    
    public void insertProduct(String name, Integer categoryid, Integer quantity, 
    		Double price, Integer weight, String description, String image) {
    	productRepository.insertProduct(name, categoryid, quantity, 
        		price, weight, description, image);
    }
    
    public void updateProduct(Integer id, String name, Integer categoryid, Integer quantity, 
    		Double price, Integer weight, String description, String image) {
    	productRepository.updateProduct(id, name, categoryid, quantity, 
        		price, weight, description, image);
    }

	public void resetDiscount(Integer id) {
		productRepository.resetDiscount(id);
	}

	public void updateDiscount(Integer discount, Integer id) {
		productRepository.updateDiscount(discount, id);	
	}

	public List<Product> searchSelling() {
		return productRepository.searchSelling();
	}
    
}
