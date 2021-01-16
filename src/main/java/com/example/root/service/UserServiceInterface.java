package com.example.root.service;

import com.example.root.dao.UserEntity;

import java.util.List;

public interface UserServiceInterface {
    int createUser(UserEntity user);

    List<UserEntity> readAllUser();

    int updateUser(UserEntity user);

    int Delete(UserEntity user);

    UserEntity myPage(String email);
}
