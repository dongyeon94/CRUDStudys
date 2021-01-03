package com.example.root.controller;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;


@SpringBootTest
@AutoConfigureMockMvc
class MainIndexTest {

    @Autowired
    MockMvc  mockMvc;

    @Test
    @DisplayName("메인 URL 테스트")
    void mainURLTest() throws Exception {
        mockMvc.perform(get("/"))
                            .andExpect(status().isOk())
                            .andDo(print());
    }
}
