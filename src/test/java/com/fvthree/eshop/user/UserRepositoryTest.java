package com.fvthree.eshop.user;

import com.fvthree.eshop.config.BaseSpringTest;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class UserRepositoryTest extends BaseSpringTest {

    @Test
    public void testAbleToFindByUsername() {
        User user = createUser();
        userRepository.save(user);
        assertNotNull(userRepository.findByUsername("TestUsername").get());
        assertEquals(true , userRepository.findByUsername("TestUsername").get().isActive());
    }
}
