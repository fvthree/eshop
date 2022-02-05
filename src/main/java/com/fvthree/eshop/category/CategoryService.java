package com.fvthree.eshop.category;

public interface CategoryService {

    CategoryDTO get(Long id);

    Category create(final CategoryDTO categoryDTO);

    void update(final Long id, final CategoryDTO categoryDTO);

    void delete(final Long id);
}
