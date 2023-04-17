package com.comp5541.ConcordiaEats.repository;

import com.comp5541.ConcordiaEats.model.Cart;
import com.comp5541.ConcordiaEats.model.CartItemInfo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface CartRepository extends JpaRepository<Cart, Cart.CartId> {
    // Additional query methods if needed
	
    @Query("SELECT c.id.product_id FROM Cart c WHERE c.id.user_id = :user_id")
    List<Integer> findProductIdsInCartByUserId(@Param("user_id") Integer user_id);
    
    @Query("SELECT new com.comp5541.ConcordiaEats.model.CartItemInfo(p, c.quantity) " +
            "FROM Product p JOIN Cart c ON p.id = c.id.product_id WHERE c.id.user_id = :user_id")
     List<CartItemInfo> findCartItemsByUserId(@Param("user_id") Integer userId);

}
