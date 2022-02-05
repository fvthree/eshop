package com.fvthree.eshop.category;

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

public class CategoryServiceTest extends BaseServiceTest {

    @Autowired
    public CategoryService categoryService;

    @Test
    public void testFindByIdShouldReturnAUser() {
        Category category = createCategory();
        when(categoryRepository.findById(category.getId())).thenReturn(Optional.ofNullable(category));
        CategoryDTO cat = categoryService.get(category.getId());
        assertNotNull(cat);
        assertEquals(category.getId(), cat.getId());
        assertEquals(category.getName(), cat.getName());
        assertEquals(category.getColor(), cat.getColor());
        assertEquals(category.getImage(), cat.getImage());
    }

    @Test
    public void testFindByIdShouldThrowExceptionWhenNotFound() {
        ResponseStatusException exception = Assertions.assertThrows(
                ResponseStatusException.class, () -> categoryService.get(3L));
        assertNotNull(exception);
    }

    @Test
    public void testCreateShouldReturnAUser() {
        Category category = createCategory();
        CategoryDTO categoryDTO = createCategoryDTO();
        when(categoryRepository.save(any())).thenReturn(category);
        Category created = categoryService.create(categoryDTO);
        assertNotNull(created);
        assertEquals(created.getName(), category.getName());
    }

    @Test
    public void testUpdate() {
        Category category = createCategory();
        CategoryDTO categoryDTO = createCategoryDTO();
        when(categoryRepository.findById(1L)).thenReturn(Optional.ofNullable(category));
        categoryService.update(1L, categoryDTO);
    }

    @Test
    public void testUpdateShouldThrowExceptionWhenNotFound() {
        ResponseStatusException exception = Assertions.assertThrows(
                ResponseStatusException.class, () -> categoryService.update(2L, new CategoryDTO()));
        assertNotNull(exception);
    }

    @Test
    public void testDelete() {
        categoryService.delete(1L);
    }
}
