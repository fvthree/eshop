package com.fvthree.eshop.config;

import com.fvthree.eshop.EshopApplication;
import com.fvthree.eshop.user.UserRepository;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.SqlMergeMode;
import org.springframework.util.StreamUtils;

import java.nio.charset.Charset;

@SpringBootTest(
        classes = EshopApplication.class,
        webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT
)
@ActiveProfiles("it")
@Sql({"/data/clearAll.sql","/data/userData.sql","/data/categoryData.sql"})
@SqlMergeMode(SqlMergeMode.MergeMode.MERGE)
public class BaseIntegrationTest {

    @Autowired
    public TestRestTemplate restTemplate;

    @Autowired
    public UserRepository userRepository;

    @SneakyThrows
    public String readResource(final String resourceName) {
        return StreamUtils.copyToString(getClass().getResourceAsStream(resourceName), Charset.forName("UTF-8"));
    }

    public HttpHeaders jsonHeader() {
        final HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        return headers;
    }
}
