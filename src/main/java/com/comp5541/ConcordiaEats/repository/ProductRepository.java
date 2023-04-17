package com.comp5541.ConcordiaEats.repository;

import com.comp5541.ConcordiaEats.model.Product;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

//import org.springframework.data.repository.query.Param;
//import org.springframework.stereotype.Repository;
import java.util.List;


//@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {
    List<Product> findByCategoryid(Integer categoryid);

    
    /*@Query("SELECT p FROM Product p WHERE " +
            "(:productName IS NULL OR LOWER(p.name) LIKE LOWER(CONCAT('%', :productName, '%'))) AND " +
            "(:minPrice IS NULL OR p.price >= :minPrice) AND " +
            "(:maxPrice IS NULL OR p.price <= :maxPrice)")
    List<Product> searchProducts(
            @Param("productName") String productName,
            @Param("minPrice") Double minPrice,
            @Param("maxPrice") Double maxPrice
    );*/
    
 // Simplified query to retrieve all products
    @Query("SELECT p FROM Product p")
    List<Product> searchProducts();
    
    @Modifying
    @Query("DELETE FROM Product WHERE id = :id")
    void deleteProduct(@Param("id")Integer id);
    
    @Modifying
    @Query("UPDATE Product SET name = :name WHERE categoryid = :categoryid")
    void updateProduct(@Param("name")String name, @Param("categoryid")Integer categoryid);
    
    @Modifying
    @Query(value = "INSERT INTO products (name) VALUES (:name)", nativeQuery = true)
    void insertProduct(@Param("name") String name);
}