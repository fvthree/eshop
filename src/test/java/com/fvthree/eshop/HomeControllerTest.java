package com.fvthree.eshop;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(
        classes= EshopApplication.class,
        webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT
)
public class HomeControllerTest {

    @Autowired
    public TestRestTemplate restTemplate;

    @Test
    public void testHelloWorldEndpoint() {
        final ResponseEntity<String> httpResponse = restTemplate.exchange("/", HttpMethod.GET,
                null, String.class);
        assertEquals(HttpStatus.OK, httpResponse.getStatusCode());
        assertEquals("Hello World", httpResponse.getBody().toString());
    }
}
