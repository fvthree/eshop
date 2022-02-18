package com.fvthree.eshop.product;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductDTO {

    private Long id;

    @NotNull
    @Size(max = 255)
    private String name;

    @NotNull
    @Size(max = 255)
    private String description;

    @NotNull
    @Size(max = 255)
    private String richDescription;

    @NotNull
    @Size(max = 255)
    private String image;

    @NotNull
    @Size(max = 255)
    private String brand;

    @NotNull
    private BigDecimal price;

    @NotNull
    private Long category;

    @NotNull
    private Integer countInStock;

    @NotNull
    private Double rating;

    @NotNull
    private Integer numReviews;

    @NotNull
    private Boolean isFeatured;

}