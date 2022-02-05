package com.fvthree.eshop.config;

import com.fvthree.eshop.category.Category;
import com.fvthree.eshop.category.CategoryDTO;
import com.fvthree.eshop.category.CategoryRepository;
import com.fvthree.eshop.user.User;
import com.fvthree.eshop.user.UserDTO;
import com.fvthree.eshop.user.UserRepository;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.time.OffsetDateTime;

@SpringBootTest
public abstract class BaseServiceTest {

    @MockBean
    public UserRepository userRepository;

    @MockBean
    public CategoryRepository categoryRepository;

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
}
