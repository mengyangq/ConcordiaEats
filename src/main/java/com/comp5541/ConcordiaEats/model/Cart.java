package com.comp5541.ConcordiaEats.model;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Embeddable;
import javax.persistence.EmbeddedId;

@Entity
@Table(name = "cart")
public class Cart {

    @EmbeddedId
    private CartId id;

    private Integer quantity;

    // Additional fields if needed

    public CartId getId() {
        return id;
    }

    public void setId(CartId id) {
        this.id = id;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    // Define the composite key class
    @Embeddable
    public static class CartId implements Serializable {
    	
    	private static final long serialVersionUID = 1L;
    	
        private Integer user_id;
        private Integer product_id;

        // Getters and setters

        public Integer getUser_id() {
            return user_id;
        }

        public void setUser_id(Integer user_id) {
            this.user_id = user_id;
        }

        public Integer getProduct_id() {
            return product_id;
        }

        public void setProduct_id(Integer product_id) {
            this.product_id = product_id;
        }

        // Override equals and hashCode methods based on user_id and product_id
        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            CartId that = (CartId) o;
            return Objects.equals(user_id, that.user_id) &&
                   Objects.equals(product_id, that.product_id);
        }

        @Override
        public int hashCode() {
            return Objects.hash(user_id, product_id);
        }
    }
}
