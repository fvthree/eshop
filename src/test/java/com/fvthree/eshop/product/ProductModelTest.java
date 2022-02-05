package com.fvthree.eshop.product;

import com.fvthree.eshop.config.BaseDaoTest;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class ProductModelTest extends BaseDaoTest {

    @Test
    public void testProductIstNotNull() {
        Product product = createProduct();
        assertNotNull(product);
        assertEquals("Red Wine", product.getName());
        assertNotNull(product.getCategory());
    }
}
