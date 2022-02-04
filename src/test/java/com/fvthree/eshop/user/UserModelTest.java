package com.fvthree.eshop.user;

import com.fvthree.eshop.config.BaseDaoTest;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class UserModelTest extends BaseDaoTest {

    @Test
    public void testUserIsNotNull(){
        User user = createUser();
        assertNotNull(user);
    }
}
