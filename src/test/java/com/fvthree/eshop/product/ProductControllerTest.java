package com.fvthree.eshop.product;

import com.fvthree.eshop.config.BaseIntegrationTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

public class ProductControllerTest extends BaseIntegrationTest {

    @BeforeEach
    public void createProduct_success() {
        when(categoryRepository.findById(any())).thenReturn(Optional.ofNullable(createCategory()));

        final HttpEntity<String> request = new HttpEntity<>(readResource("/requests/createProductRequest.json"), jsonHeader());
        final ResponseEntity<Product> response = restTemplate.exchange("/api/products", HttpMethod.POST, request, Product.class);

        assertEquals(HttpStatus.CREATED, response.getStatusCode());
    }

    @Test
    public void getProductById_success() {
        final ResponseEntity<ProductDTO> resp = restTemplate.exchange("/api/products/1000", HttpMethod.GET, null, ProductDTO.class);

        assertEquals(HttpStatus.OK, resp.getStatusCode());
        assertEquals("Accessory", resp.getBody().getName());
        assertEquals("White", resp.getBody().getDescription());
        assertEquals(false, resp.getBody().getIsFeatured());
    }

    @Test
    public void getProductById_notFound(){
        final ResponseEntity<ProductDTO> resp = restTemplate.exchange("/api/products/100", HttpMethod.GET, null, ProductDTO.class);

        assertEquals(HttpStatus.NOT_FOUND, resp.getStatusCode());
    }

    @Test
    public void updateProduct_success() {
        final HttpEntity<String> req = new HttpEntity<>(readResource("/requests/productDTORequest.json"), jsonHeader());
        final ResponseEntity<Void> resp = restTemplate.exchange("/api/products/1000", HttpMethod.PUT, req, Void.class);

        assertEquals(HttpStatus.OK, resp.getStatusCode());
    }

    @Test
    public void updateProduct_NotSuccess() {
        final HttpEntity<String> req = new HttpEntity<>(readResource("/requests/productDTORequest.json"), jsonHeader());
        final ResponseEntity<Void> resp = restTemplate.exchange("/api/products/100", HttpMethod.PUT, req, Void.class);

        assertEquals(HttpStatus.NOT_FOUND, resp.getStatusCode());
    }

    @Test
    public void deleteProduct_success() {
        final ResponseEntity<Void> resp2 = restTemplate.exchange("/api/products/1000", HttpMethod.DELETE, null, Void.class);
        assertEquals(HttpStatus.NO_CONTENT, resp2.getStatusCode());
    }
}
