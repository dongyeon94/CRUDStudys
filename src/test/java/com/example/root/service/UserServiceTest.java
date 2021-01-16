package com.example.root.service;

import com.example.root.dao.UserEntity;
import com.example.root.repo.UserRepo;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.util.MultiValueMap;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class UserServiceTest {

    @Autowired
    UserService userService;
    @Autowired
    UserRepo userRepo;
    @Autowired
    PasswordEncoder passwordEncoder;

    UserEntity userEntity;

    @BeforeEach
    void setUser() {
        userEntity = new UserEntity();
        userEntity.setEmail("logout@gmail.com");
        userEntity.setPassword(passwordEncoder.encode("1234"));
    }


    @Test
    void createTest() throws Exception {
        assertAll("insert test",
                () -> userRepo.save(userEntity));
    }

    @Test
    void readAllUserTest() {
        assertAll("user list check",
                () -> assertEquals(userRepo.findAll(), userService.readAllUser())
        );
    }
}