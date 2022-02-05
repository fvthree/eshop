package com.fvthree.eshop.category;

import com.fvthree.eshop.config.BaseDaoTest;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class CategoryModelTest extends BaseDaoTest {

    @Test
    public void categoryNotNull() {
        Category category = createCategory();
        assertNotNull(category);
        assertEquals(1, category.getId());
        assertEquals("Tops", category.getName());
    }

}
