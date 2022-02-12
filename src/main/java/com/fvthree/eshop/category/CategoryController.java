package com.fvthree.eshop.category;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping(value = "/api/categories", produces = MediaType.APPLICATION_JSON_VALUE)
public class CategoryController {

    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> get(@PathVariable final Long id) {
        return ResponseEntity.ok(categoryService.get(id));
    }

    @PostMapping
    public ResponseEntity<?> create(@RequestBody @Valid final CategoryDTO categoryDTO){
        return new ResponseEntity<>(categoryService.create(categoryDTO), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable final Long id, @RequestBody final CategoryDTO categoryDTO) {
        categoryService.update(id, categoryDTO);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable final Long id) {
        categoryService.delete(id);
        return ResponseEntity.noContent().build();
    }

}
