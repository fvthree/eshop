package com.fvthree.eshop.product;

import com.fvthree.eshop.category.Category;
import com.fvthree.eshop.category.CategoryRepository;
import org.mapstruct.*;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

@Mapper(
        componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE
)
public interface ProductMapper {

    @Mapping(target = "category", ignore = true)
    ProductDTO updateProductDTO(Product product, @MappingTarget ProductDTO productDTO);

    @AfterMapping
    default void afterUpdateProductDTO(Product product,
                                           @MappingTarget ProductDTO productDTO) {
        productDTO.setCategory(product.getCategory() == null ? null : product.getCategory().getId());
    }

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "category", ignore = true)
    Product updateProduct(ProductDTO productDTO, @MappingTarget Product product, @Context CategoryRepository categoryRepository);

    @AfterMapping
    default void afterUpdateProduct(ProductDTO productDTO,
                                        @MappingTarget Product product, @Context CategoryRepository categoryRepository) {
        if (productDTO.getCategory() != null && (product.getCategory() == null || !product.getCategory().getId().equals(productDTO.getCategory()))) {
            final Category category = categoryRepository.findById(productDTO.getCategory())
                    .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "category not found"));
            product.setCategory(category);
        }
    }
}