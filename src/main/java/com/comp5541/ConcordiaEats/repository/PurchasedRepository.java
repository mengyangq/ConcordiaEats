package com.comp5541.ConcordiaEats.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.comp5541.ConcordiaEats.model.*;


@Repository
public interface PurchasedRepository extends JpaRepository<Purchased, Purchased.PurchasedId> {
	// Fetch purchased products for a specific user
    @Query("SELECT p FROM Product p JOIN Purchased pur ON p.id = pur.id.product_id WHERE pur.id.user_id = :user_id")
    List<Product> findPurchasedProductsByUserId(@Param("user_id") Integer user_id);
}
