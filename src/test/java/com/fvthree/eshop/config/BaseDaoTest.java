package com.fvthree.eshop.config;

import com.fvthree.eshop.EshopApplication;
import com.fvthree.eshop.category.Category;
import com.fvthree.eshop.category.CategoryRepository;
import com.fvthree.eshop.product.Product;
import com.fvthree.eshop.product.ProductRepository;
import com.fvthree.eshop.user.User;
import com.fvthree.eshop.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.time.OffsetDateTime;

@SpringBootTest(
        classes = EshopApplication.class,
        webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT
)
public abstract class BaseDaoTest {

    @Autowired
    public UserRepository userRepository;

    @Autowired
    public CategoryRepository categoryRepository;

    @Autowired
    public ProductRepository productRepository;

    protected User createUser() {
        return User.builder()
                .id(1L)
                .name("Test Name")
                .username("TestUsername")
                .email("test@gmail.com")
                .password("123456")
                .apartment("B304")
                .zip("4213")
                .city("Manila")
                .country("PH")
                .street("Victoria")
                .phone("+631231234")
                .isAdmin(false)
                .isActive(true)
                .isNotLocked(true)
                .dateCreated(OffsetDateTime.now())
                .lastUpdated(OffsetDateTime.now())
                .build();
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
}
