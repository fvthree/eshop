package com.fvthree.eshop.user;

import com.fvthree.eshop.config.BaseIntegrationTest;
import org.junit.jupiter.api.*;
import org.springframework.http.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class UserControllerTest extends BaseIntegrationTest {

    @BeforeEach
    public void createUser_success() {

        final HttpEntity<String> request = new HttpEntity<>(readResource("/requests/createUserDTORequest.json"), jsonHeader());
        final ResponseEntity<User> response = restTemplate.exchange("/api/users", HttpMethod.POST, request, User.class);

        assertEquals(HttpStatus.CREATED, response.getStatusCode());
    }

    @Test
    public void getUserById_success() {
        final ResponseEntity<UserDTO> resp = restTemplate.exchange("/api/users/1200", HttpMethod.GET, null, UserDTO.class);

        assertEquals(HttpStatus.OK, resp.getStatusCode());
        assertEquals("script", resp.getBody().getName());
        assertEquals("script", resp.getBody().getUsername());
        assertEquals("script@mail.com", resp.getBody().getEmail());
    }

    @Test
    public void getUserById_notFound(){
        final ResponseEntity<UserDTO> resp = restTemplate.exchange("/api/users/100", HttpMethod.GET, null, UserDTO.class);

        assertEquals(HttpStatus.NOT_FOUND, resp.getStatusCode());
    }

    @Test
    public void updateUser_success() {
        final HttpEntity<String> req = new HttpEntity<>(readResource("/requests/userDTORequest.json"), jsonHeader());
        final ResponseEntity<Void> resp = restTemplate.exchange("/api/users/1200", HttpMethod.PUT, req, Void.class);

        assertEquals(HttpStatus.OK, resp.getStatusCode());
    }

    @Test
    public void updateUser_NotSuccess() {
        final HttpEntity<String> req = new HttpEntity<>(readResource("/requests/userDTORequest.json"), jsonHeader());
        final ResponseEntity<Void> resp = restTemplate.exchange("/api/users/100", HttpMethod.PUT, req, Void.class);

        assertEquals(HttpStatus.NOT_FOUND, resp.getStatusCode());
    }

    @Test
    public void deleteUser_success() {
        final ResponseEntity<Void> resp = restTemplate.exchange("/api/users/1200", HttpMethod.DELETE, null, Void.class);
        assertEquals(HttpStatus.NO_CONTENT, resp.getStatusCode());
    }
}
