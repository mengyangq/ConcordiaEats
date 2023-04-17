package com.comp5541.ConcordiaEats.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class FavoriteIdTest {

    @Test
    public void testEqualsAndHashCode() {
        // Create two FavoriteId objects with the same user_id and product_id
        Favorite.FavoriteId favoriteId1 = new Favorite.FavoriteId();
        favoriteId1.setUser_id(1);
        favoriteId1.setProduct_id(100);

        Favorite.FavoriteId favoriteId2 = new Favorite.FavoriteId();
        favoriteId2.setUser_id(1);
        favoriteId2.setProduct_id(100);

        // Create a third FavoriteId object with different user_id and product_id
        Favorite.FavoriteId favoriteId3 = new Favorite.FavoriteId();
        favoriteId3.setUser_id(2);
        favoriteId3.setProduct_id(200);

        // Assert that the two FavoriteId objects with the same user_id and product_id are equal
        assertEquals(favoriteId1, favoriteId2);
        // Assert that their hash codes are equal
        assertEquals(favoriteId1.hashCode(), favoriteId2.hashCode());

        // Assert that the two FavoriteId objects with different user_id and product_id are not equal
        assertNotEquals(favoriteId1, favoriteId3);
        // Assert that their hash codes are not equal
        assertNotEquals(favoriteId1.hashCode(), favoriteId3.hashCode());
    }
}
