package com.comp5541.ConcordiaEats.model;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Embeddable;
import javax.persistence.EmbeddedId;

@Entity
@Table(name = "favorites")
public class Favorite {

    @EmbeddedId
    private FavoriteId id;

    // Additional fields if needed

    public FavoriteId getId() {
        return id;
    }

    public void setId(FavoriteId id) {
        this.id = id;
    }

    // Define the composite key class
    @Embeddable
    public static class FavoriteId implements Serializable {
    	
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
            FavoriteId that = (FavoriteId) o;
            return Objects.equals(user_id, that.user_id) &&
                   Objects.equals(product_id, that.product_id);
        }

        @Override
        public int hashCode() {
            return Objects.hash(user_id, product_id);
        }
    }
}
