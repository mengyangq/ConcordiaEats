package com.comp5541.ConcordiaEats.service;

import com.comp5541.ConcordiaEats.model.Product;
import com.comp5541.ConcordiaEats.model.Favorite;
import com.comp5541.ConcordiaEats.repository.FavoriteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FavoriteService {
    @Autowired
    private FavoriteRepository favoriteRepository;

    public List<Product> getFavoriteProductsByUserId(Integer user_id) {
        // Retrieve the favorite products for the user using the custom query method
        return favoriteRepository.findFavoriteProductsByUserId(user_id);
    }
    
    public void removeProductFromFavorites(Integer userId, Integer productId) {
        // Create a FavoriteId instance representing the composite key
        Favorite.FavoriteId id = new Favorite.FavoriteId();
        id.setUser_id(userId);
        id.setProduct_id(productId);

        // Delete the favorite from the favorites table using the composite key
        favoriteRepository.deleteById(id);
    }
}
