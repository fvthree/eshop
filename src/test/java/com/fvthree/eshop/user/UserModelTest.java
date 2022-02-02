package com.fvthree.eshop.user;

import com.fvthree.eshop.config.BaseSpringTest;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class UserModelTest extends BaseSpringTest {

    @Test
    public void testUserIsNotNull(){
        User user = createUser();
        assertNotNull(user);
    }
}
