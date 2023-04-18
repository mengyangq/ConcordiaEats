package com.comp5541.ConcordiaEats.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.comp5541.ConcordiaEats.model.Product;

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
    
    @Query("SELECT p FROM Product p where id = :id")
    Product searchProducts(@Param("id")Integer id);
    
    /*@Query("SELECT COUNT(*) FROM Product p where id != :id AND name = :name")
    Integer searchDuplicate(@Param("id")Integer id, @Param("name")String name);*/
    
    @Modifying
    @Query("DELETE FROM Product WHERE id = :id")
    void deleteProduct(@Param("id")Integer id);
    
    @Modifying
    @Query(value = "INSERT INTO products (name, categoryid, quantity, price, weight, description, image) VALUES (:name, :categoryid, :quantity, :price, :weight, :description, :image)", nativeQuery = true)
    void insertProduct(@Param("name") String name,
    		@Param("categoryid")Integer categoryid, 
    		@Param("quantity")Integer quantity, 
    		@Param("price")Double price, 
    		@Param("weight")Integer weight, 
    		@Param("description")String description, 
    		@Param("image")String image
    		);

    
    @Modifying
    @Query("UPDATE Product SET name = :name, categoryid = :categoryid, quantity = :quantity, "
    		+ "price = :price, weight = :weight, description = :description, image = :image WHERE id = :id")
    void updateProduct(@Param("id")Integer id,
    		@Param("name") String name,
    		@Param("categoryid")Integer categoryid, 
    		@Param("quantity")Integer quantity, 
    		@Param("price")Double price, 
    		@Param("weight")Integer weight, 
    		@Param("description")String description, 
    		@Param("image")String image
    		);
    
    @Modifying
    @Query("UPDATE Product SET onsale = 0, discount = 0 WHERE id = :id")
	void resetDiscount(@Param("id")Integer id);

    @Modifying
    @Query("UPDATE Product SET onsale = 1, discount = :discount WHERE id = :id")
	void updateDiscount(@Param("discount")Integer discount, @Param("id")Integer id);

    @Modifying
    @Query("SELECT p FROM Product p ORDER BY sold DESC, price DESC, name ASC, onsale ASC")
	List<Product> searchSelling();
}


