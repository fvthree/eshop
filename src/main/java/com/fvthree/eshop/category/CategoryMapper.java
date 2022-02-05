package com.fvthree.eshop.category;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.ReportingPolicy;

@Mapper(
        componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE
)
public interface CategoryMapper {

    @Mapping(target = "id")
    CategoryDTO updateCategoryDTO(Category category, @MappingTarget CategoryDTO categoryDTO);

    @Mapping(target = "id", ignore = true)
    Category updateCategory(CategoryDTO categoryDTO, @MappingTarget Category category);
}
