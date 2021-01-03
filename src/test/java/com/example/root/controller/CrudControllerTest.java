package com.example.root.controller;

import com.example.root.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class CrudControllerTest {

    @Autowired
    MockMvc mockMvc;


    @Test
    void createTest() throws Exception {
        mockMvc.perform(post("/create")
                            .param("email","logout94@naver.com")
                            .param("password","1234"))
                            .andExpect(status().is3xxRedirection())
                            .andDo(print());
    }
}