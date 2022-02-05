package com.fvthree.eshop.category;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import javax.transaction.Transactional;

@Service
@Transactional
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;

    private final CategoryMapper categoryMapper;

    public CategoryServiceImpl(CategoryRepository categoryRepository, CategoryMapper categoryMapper) {
        this.categoryRepository = categoryRepository;
        this.categoryMapper = categoryMapper;
    }

    @Override
    public CategoryDTO get(Long id) {
        return categoryRepository.findById(id)
                .map(category -> categoryMapper.updateCategoryDTO(category, new CategoryDTO()))
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @Override
    public Category create(CategoryDTO categoryDTO) {
        final Category category = new Category();
        categoryMapper.updateCategory(categoryDTO, category);
        return categoryRepository.save(category);
    }

    @Override
    public void update(Long id, final CategoryDTO categoryDTO) {
        Category cat = categoryRepository.findById(id)
            .map(category -> categoryMapper.updateCategory(categoryDTO, category))
            .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        categoryRepository.save(cat);
    }

    @Override
    public void delete(Long id) {
        categoryRepository.deleteById(id);
    }
}
