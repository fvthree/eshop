package com.fvthree.eshop.product;

import com.fvthree.eshop.category.CategoryRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import javax.transaction.Transactional;

@Service
@Transactional
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    private final ProductMapper productMapper;

    private final CategoryRepository categoryRepository;

    public ProductServiceImpl(ProductRepository productRepository, ProductMapper productMapper, CategoryRepository categoryRepository) {
        this.productRepository = productRepository;
        this.productMapper = productMapper;
        this.categoryRepository = categoryRepository;
    }

    @Override
    public ProductDTO get(Long id) {
        return productRepository.findById(id)
                .map(product -> productMapper.updateProductDTO( product, new ProductDTO()))
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @Override
    public Product create(ProductDTO productDTO) {
        Product product = new Product();
        productMapper.updateProduct(productDTO, product, categoryRepository);
        return productRepository.save(product);
    }

    @Override
    public void update(Long id, ProductDTO productDTO) {
        Product prod = productRepository.findById(id)
                .map(product -> productMapper.updateProduct(productDTO, product, categoryRepository))
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        productRepository.save(prod);
    }

    @Override
    public void delete(Long id) {
        productRepository.deleteById(id);
    }
}
