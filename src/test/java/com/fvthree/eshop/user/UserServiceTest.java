package com.fvthree.eshop.user;

import com.fvthree.eshop.config.BaseServiceTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

public class UserServiceTest extends BaseServiceTest {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    public UserService userService;

    @Test
    public void testFindByUsernameShouldReturnAUser() {
        User user = createUser();
        when(userRepository.findByUsername(user.getUsername())).thenReturn(Optional.ofNullable(user));
        User foundUser = userService.findByUserByUsername(user.getUsername());
        assertNotNull(foundUser);
        assertEquals(foundUser.getId(), user.getId());
        assertEquals(foundUser.getUsername(), user.getUsername());
        assertEquals(foundUser.getEmail(), user.getEmail());
        assertEquals(foundUser.getName(), user.getName());
    }

    @Test
    public void testFindByUsernameShouldThrowExceptionWhenNotFound() {
        ResponseStatusException exception = Assertions.assertThrows(
                ResponseStatusException.class, () -> userService.findByUserByUsername("UNK"));
        assertNotNull(exception);
    }

    @Test
    public void testFindByIdShouldReturnAUser() {
        User user = createUser();
        when(userRepository.findById(user.getId())).thenReturn(Optional.ofNullable(user));
        UserDTO foundUser = userService.get(user.getId());
        assertNotNull(foundUser);
        assertEquals(foundUser.getId(), user.getId());
        assertEquals(foundUser.getUsername(), user.getUsername());
        assertEquals(foundUser.getEmail(), user.getEmail());
        assertEquals(foundUser.getName(), user.getName());
    }

    @Test
    public void testFindByIdShouldThrowExceptionWhenNotFound() {
        ResponseStatusException exception = Assertions.assertThrows(
                ResponseStatusException.class, () -> userService.get(3L));
        assertNotNull(exception);
    }

    @Test
    public void testCreateShouldReturnAUser() {
        User user = createUser();
        UserDTO userDTO = createUserDTO();
        when(userRepository.save(any())).thenReturn(user);
        User created = userService.create(userDTO);
        assertNotNull(created);
        assertEquals(user.getUsername(), created.getUsername());
    }

    @Test
    public void testUpdate() {
        UserDTO userDTO = createUserDTO();
        User user = createUser();
        when(userRepository.findById(1L)).thenReturn(Optional.ofNullable(user));
        userService.update(1L, userDTO);
    }

    @Test
    public void testUpdateShouldThrowExceptionWhenNotFound() {
        ResponseStatusException exception = Assertions.assertThrows(
                ResponseStatusException.class, () -> userService.update(3L, new UserDTO()));
        assertNotNull(exception);
    }

    @Test
    public void testDelete() {
        userService.delete(1L);
    }
}
