package com.example.demo.controller;


import static org.hamcrest.Matchers.equalTo;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class HelloControllerTest {

    @Autowired
    private MockMvc mvc;

    @Test
    public void getHello() throws Exception {
        mvc.perform(MockMvcRequestBuilders.get("/").accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().string(equalTo("<!DOCTYPE html>\\n<html xmlns=\\\"http://www.w3.org/1999/xhtml\\\" xmlns:sec=\\\"https://www.thymeleaf.org/thymeleaf-extras-springsecurity3\\\">\\n<head>\\n    <title>Spring Security Example</title>\\n</head>\\n<body>\\n<h1>Welcome!</h1>\\n\\n<p>Click <a href=\\\"/hello\\\">here</a> to see a greeting.</p>\\n</body>\\n</html>")));
    }
}