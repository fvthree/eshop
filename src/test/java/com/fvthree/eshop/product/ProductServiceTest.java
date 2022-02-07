package com.fvthree.eshop.product;

import com.fvthree.eshop.category.Category;
import com.fvthree.eshop.config.BaseServiceTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

public class ProductServiceTest extends BaseServiceTest {

    @Autowired
    public ProductService productService;

    @Test
    public void testFindByIdShouldReturnAProduct() {
        Product product = createProduct();
        Category category = createCategory();
        when(productRepository.findById(product.getId())).thenReturn(Optional.ofNullable(product));
        when(categoryRepository.findById(product.getCategory().getId())).thenReturn(Optional.ofNullable(category));
        ProductDTO productDTO = productService.get(product.getId());
        assertNotNull(productDTO);
        assertEquals(product.getId(), productDTO.getId());
        assertEquals(product.getName(), productDTO.getName());
        assertEquals(product.getDescription(), productDTO.getDescription());
        assertEquals(product.getRichDescription(), productDTO.getRichDescription());
        assertEquals(product.getCategory().getId(), productDTO.getCategory());
    }

    @Test
    public void testFindByIdShouldThrowExceptionWhenNotFound() {
        ResponseStatusException exception = Assertions.assertThrows(
                ResponseStatusException.class, () -> productService.get(3L));
        assertNotNull(exception);
    }

    @Test
    public void testCreateShouldReturnAProduct() {
        Product product = createProduct();
        ProductDTO productDTO = createProductDTO();
        when(productRepository.save(any())).thenReturn(product);
        when(categoryRepository.findById(any())).thenReturn(Optional.ofNullable(product.getCategory()));
        Product created = productService.create(productDTO);
        assertNotNull(created);
        assertEquals(created.getName(), product.getName());
        assertNotNull(created.getCategory());
    }

    @Test
    public void testUpdate() {
        Product product = createProduct();
        ProductDTO productDTO = createProductDTO();
        when(productRepository.findById(1L)).thenReturn(Optional.ofNullable(product));
        productService.update(1L, productDTO);
    }

    @Test
    public void testUpdateShouldThrowExceptionWhenNotFound() {
        ResponseStatusException exception = Assertions.assertThrows(
                ResponseStatusException.class, () -> productService.update(2L, new ProductDTO()));
        assertNotNull(exception);
    }

    @Test
    public void testDelete() {
        productService.delete(1L);
    }
}
