package com.fvthree.eshop.config;

import com.fvthree.eshop.EshopApplication;
import com.fvthree.eshop.category.Category;
import com.fvthree.eshop.category.CategoryRepository;
import com.fvthree.eshop.user.User;
import com.fvthree.eshop.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

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

    protected User createUser() {
        return User.builder()
                .id(1L)
                .name("Test Name")
                .username("TestUsername")
                .email("test@gmail.com")
                .password("123456")
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
}
