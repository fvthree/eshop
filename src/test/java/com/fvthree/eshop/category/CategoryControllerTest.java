package com.fvthree.eshop.category;

import com.fvthree.eshop.config.BaseIntegrationTest;
import com.fvthree.eshop.user.User;
import com.fvthree.eshop.user.UserDTO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CategoryControllerTest extends BaseIntegrationTest {

    @BeforeEach
    public void createCategory_success() {

        final HttpEntity<String> request = new HttpEntity<>(readResource("/requests/createCategoryRequest.json"), jsonHeader());
        final ResponseEntity<Category> response = restTemplate.exchange("/api/categories", HttpMethod.POST, request, Category.class);

        assertEquals(HttpStatus.CREATED, response.getStatusCode());
    }

    @Test
    public void getCategoryById_success() {
        final ResponseEntity<CategoryDTO> resp = restTemplate.exchange("/api/categories/1000", HttpMethod.GET, null, CategoryDTO.class);

        assertEquals(HttpStatus.OK, resp.getStatusCode());
    }

    @Test
    public void getCategoryById_notFound(){
        final ResponseEntity<CategoryDTO> resp = restTemplate.exchange("/api/categories/101", HttpMethod.GET, null, CategoryDTO.class);

        assertEquals(HttpStatus.NOT_FOUND, resp.getStatusCode());
    }

    @Test
    public void updateCategory_success() {
        final HttpEntity<String> req = new HttpEntity<>(readResource("/requests/categoryDTORequest.json"), jsonHeader());
        final ResponseEntity<Void> resp = restTemplate.exchange("/api/categories/1000", HttpMethod.PUT, req, Void.class);

        assertEquals(HttpStatus.OK, resp.getStatusCode());
    }

    @Test
    public void updateCategory_NotSuccess() {
        final HttpEntity<String> req = new HttpEntity<>(readResource("/requests/categoryDTORequest.json"), jsonHeader());
        final ResponseEntity<Void> resp = restTemplate.exchange("/api/categories/101", HttpMethod.PUT, req, Void.class);

        assertEquals(HttpStatus.NOT_FOUND, resp.getStatusCode());
    }

    @Test
    public void deleteCategory_success() {
        final ResponseEntity<Void> resp = restTemplate.exchange("/api/categories/1000", HttpMethod.DELETE, null, Void.class);
        assertEquals(HttpStatus.NO_CONTENT, resp.getStatusCode());
    }
}
