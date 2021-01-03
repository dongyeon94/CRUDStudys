package com.example.root.service;

import com.example.root.dao.UserEntity;
import com.example.root.error.StatusDefine;
import com.example.root.repo.UserRepo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class UserService implements UserServiceInterface {

    @Autowired
    private UserRepo userRepo;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public int createUser (UserEntity user) {
        UserEntity newUser = new UserEntity();
        try {
            newUser.setEmail(user.getEmail());
            newUser.setId(user.getId());
            newUser.setPassword(passwordEncoder.encode(user.getPassword()));
            userRepo.save(newUser);
            log.info(newUser.getEmail()+" insert success");
            return StatusDefine.SUCCESS.getCode();

        }catch (Exception e)
        {
            log.error(e.getMessage());
            return StatusDefine.ERROR_BAD_REQUEST.getCode();
        }

    }

    @Override
    public List<UserEntity> readAllUser() {
        try {
            log.info("read success");
            List<UserEntity> UserList = userRepo.findAll();
            return UserList;
        }catch (Exception e) {
            log.error(e.getMessage());
            return null;
        }
    }

    @Override
    public int updateUser(UserEntity user) {
        return StatusDefine.SUCCESS.getCode();
    }

    @Override
    public int Delete(UserEntity user) {
        try {
            if (userRepo.findByEmail(user.getEmail()) != null) {
                userRepo.deleteByEmail(user.getEmail());
            }
            else{
                return StatusDefine.ERROR_BAD_REQUEST.getCode();
            }
            return StatusDefine.SUCCESS.getCode();
        }catch (Exception e) {
            log.error(e.getMessage());
            return StatusDefine.ERROR_BAD_REQUEST.getCode();
        }
    }
}
