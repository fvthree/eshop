package com.fvthree.eshop.config;

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
}
