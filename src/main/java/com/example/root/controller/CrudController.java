package com.example.root.controller;

import com.example.root.dao.UserEntity;
import com.example.root.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@Slf4j
public class CrudController {

    @Autowired
    private UserService userService;

    @GetMapping("/create")
    public String createPage(){
        log.info("create page load success");
        return "CRUD/create";
    }

    @PostMapping("/create")
    public String create(UserEntity user){
        if (userService.createUser(user) == 200) {
            log.info("user data insert success");
            return "redirect:/";
        }
        else {
            log.error("insert fail");
            return "CRUD/create";
        }
    }

    @GetMapping("/read")
    public String readPage(Model model, UserEntity userEntity) {
        model.addAttribute("userData",userService.readAllUser());
        return "CRUD/read";
    }


    @GetMapping("/delete")
    public String deletePage() {
        return "CRUD/delete";
    }

    @PostMapping("/delete")
    public String delete(UserEntity user) {
        userService.Delete(user);
        return "CRUD/delete";
    }
}
