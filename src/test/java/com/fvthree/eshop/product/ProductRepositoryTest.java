package com.fvthree.eshop.product;

import com.fvthree.eshop.category.Category;
import com.fvthree.eshop.config.BaseDaoTest;
import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ProductRepositoryTest extends BaseDaoTest {

    @BeforeEach
    public void initializeCategory() {
        Category category = createCategory();
        categoryRepository.save(category);
    }

    @Test
    public void testCreateProduct() {
        Product product = createProduct();
        productRepository.save(product);
        assertEquals(1, productRepository.count());
    }
}
