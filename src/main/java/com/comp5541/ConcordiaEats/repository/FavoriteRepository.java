package com.comp5541.ConcordiaEats.repository;

import com.comp5541.ConcordiaEats.model.Favorite;
import com.comp5541.ConcordiaEats.model.Product;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface FavoriteRepository extends JpaRepository<Favorite, Favorite.FavoriteId> {
    // Additional query methods if needed
	
	@Query("SELECT f.id.product_id FROM Favorite f WHERE f.id.user_id = :user_id")
    List<Integer> findFavoritedProductIdsByUserId(@Param("user_id") Integer user_id);
	
	@Query("SELECT p FROM Product p JOIN Favorite f ON p.id = f.id.product_id WHERE f.id.user_id = :user_id")
    List<Product> findFavoriteProductsByUserId(@Param("user_id") Integer user_id);
}
