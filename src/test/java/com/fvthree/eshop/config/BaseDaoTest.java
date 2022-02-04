package com.fvthree.eshop.config;

import com.fvthree.eshop.EshopApplication;
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

    protected User createSecondUser() {
        return User.builder()
                .id(2L)
                .name("Luke SkyWalker")
                .username("luke.skywalker")
                .email("lukeskywalker@gmail.com")
                .password("123456")
                .isActive(true)
                .isNotLocked(true)
                .dateCreated(OffsetDateTime.now())
                .lastUpdated(OffsetDateTime.now())
                .build();
    }
}
