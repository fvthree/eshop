package com.fvthree.eshop.config;

import com.fvthree.eshop.category.Category;
import com.fvthree.eshop.category.CategoryDTO;
import com.fvthree.eshop.category.CategoryRepository;
import com.fvthree.eshop.product.Product;
import com.fvthree.eshop.product.ProductDTO;
import com.fvthree.eshop.product.ProductRepository;
import com.fvthree.eshop.user.User;
import com.fvthree.eshop.user.UserDTO;
import com.fvthree.eshop.user.UserRepository;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.math.BigDecimal;
import java.time.OffsetDateTime;

@SpringBootTest
public abstract class BaseServiceTest {

    @MockBean
    public UserRepository userRepository;

    @MockBean
    public CategoryRepository categoryRepository;

    @MockBean
    public ProductRepository productRepository;

    protected User createUser() {
        return User.builder()
                .id(1L)
                .name("Mock Name")
                .username("MockUsername")
                .email("mock@mail.com")
                .password("123456")
                .isActive(true)
                .isNotLocked(true)
                .dateCreated(OffsetDateTime.now())
                .lastUpdated(OffsetDateTime.now())
                .build();
    }

    protected UserDTO createUserDTO() {
        return new UserDTO(1L, "updated", "update", "update@mail.com","12345");
    }

    protected Category createCategory(){
        return Category.builder()
                .id(1L)
                .name("Tops")
                .color("Black")
                .image("/images/images.png")
                .icon("/images/tops.png")
                .build();
    }

    protected CategoryDTO createCategoryDTO() {
        return new CategoryDTO(1L, "Bottoms","Black","images/icon.png","images/images.png");
    }

    protected Product createProduct() {
        return Product.builder()
                .id(1L)
                .name("Red Wine")
                .description("A perfectly created wine from Spain.")
                .richDescription("Red wine is a type of wine made from dark-colored grape varieties. The actual color of the wine can range from intense violet, typical of young wines, through to brick red for mature wines and brown for older red wines.")
                .image("image.png")
                .brand("Gaja Barbaresco")
                .price(new BigDecimal(100.00))
                .category(createCategory())
                .countInStock(10)
                .rating(5.0)
                .numReviews(22)
                .isFeatured(true)
                .build();
    }

    protected ProductDTO createProductDTO() {
        return new ProductDTO(2L, "Hyper dunk", "authentic", "limited edition shoe","nike.png","Nike", new BigDecimal(10.00), 1L, 10, 5.0,22, true);
    }
}
