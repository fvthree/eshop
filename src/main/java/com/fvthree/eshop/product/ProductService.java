package com.fvthree.eshop.product;

public interface ProductService {

    ProductDTO get(Long id);

    Product create(final ProductDTO productDTO);

    void update(final Long id, final ProductDTO productDTO);

    void delete(final Long id);
}
