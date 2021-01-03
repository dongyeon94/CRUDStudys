package com.example.root.service;

import com.example.root.constant.StatusDefine;
import com.example.root.dao.UserEntity;
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
            return StatusDefine.SUCCESS;

        }catch (Exception e)
        {
            log.error(e.getMessage());
            return StatusDefine.ERROR_BAD_REQUEST;
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
        return StatusDefine.SUCCESS;
    }

    @Override
    public int Delete(UserEntity user) {
        try {
            if (userRepo.findByEmail(user.getEmail()) != null) {
                UserEntity userData = userRepo.findByEmail(user.getEmail());
                if (passwordEncoder.matches(user.getPassword(),userData.getPassword())) {
                    userRepo.deleteByEmail(user.getEmail());
                    log.info("delete success");
                    return StatusDefine.SUCCESS;
                }
                else {
                    log.error(user.getEmail()+" password dis match");
                    return StatusDefine.ERROR_UNAUTHORIZED;
                }
            }
            else{
                log.error(user.getEmail() + " user not found");
                return StatusDefine.ERROR_NOT_FOUNT;
            }
        }catch (Exception e) {
            log.error(e.getMessage());
            return StatusDefine.ERROR_BAD_REQUEST;
        }
    }
}
