package com.example.demo.controller;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;

import java.net.URL;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

//@RunWith(SpringRunner.class)
//@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class HelloControllerIT {

    @LocalServerPort
    private int port;

    private URL base;

    @Autowired
    private TestRestTemplate template;

    @Before
    public void setUp() throws Exception {
        this.base = new URL("http://localhost:" + port + "/");
    }

    @Test
    public void getHello() throws Exception {
        ResponseEntity<String> response = template.getForEntity(base.toString(),
                String.class);
        assertThat(response.getBody(), equalTo("<!DOCTYPE html>\\n<html xmlns=\\\"http://www.w3.org/1999/xhtml\\\" xmlns:sec=\\\"https://www.thymeleaf.org/thymeleaf-extras-springsecurity3\\\">\\n<head>\\n    <title>Spring Security Example</title>\\n</head>\\n<body>\\n<h1>Welcome!</h1>\\n\\n<p>Click <a href=\\\"/hello\\\">here</a> to see a greeting.</p>\\n</body>\\n</html>"));
    }
}
