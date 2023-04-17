package com.comp5541.ConcordiaEats.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class CategoryTest {

    @Test
    public void testCategory() {
        // Create a Category object and set its properties
        Category category1 = new Category();
        category1.setCategoryid(1);
        category1.setName("Electronics");

        // Assert that the properties are set correctly
        assertEquals(1, category1.getCategoryid());
        assertEquals("Electronics", category1.getName());

        // Create another Category object with different properties
        Category category2 = new Category();
        category2.setCategoryid(2);
        category2.setName("Books");

        // Assert that the properties are set correctly
        assertEquals(2, category2.getCategoryid());
        assertEquals("Books", category2.getName());

        // Assert that the two Category objects are not equal
        assertNotEquals(category1, category2);
    }
}
