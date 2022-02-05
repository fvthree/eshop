package com.fvthree.eshop.category;

import com.fvthree.eshop.config.BaseDaoTest;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CategoryRepositoryTest extends BaseDaoTest {

    @Test
    public void testInsertCategory() {
        Category category = createCategory();
        categoryRepository.save(category);
        assertEquals(1, categoryRepository.count());
    }
}
