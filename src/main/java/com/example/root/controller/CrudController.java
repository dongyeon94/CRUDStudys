package com.example.root.controller;

import com.example.root.constant.ErrorPageFilter;
import com.example.root.constant.StatusDefine;
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

    @GetMapping("/mypage")
    public String myPage(Model model) {
        return "CRUD/myPage";
    }

    @PostMapping("/mypage")
    public String myPageLoad(Model model, String email) {
        model.addAttribute("userData", userService.myPage(email));
        return "CRUD/myPage";
    }

    @GetMapping("/create")
    public String createPage(Model model) {
        try {
            log.info("create page load success");
            return "CRUD/create";
        } catch (Exception e) {
            model.addAttribute("errorCdoe", 404);
            log.error("error " + e.getMessage());
            return ErrorPageFilter.errorPage;
        }
    }

    @PostMapping("/create")
    public String create(UserEntity user) {
        if (userService.createUser(user) == 200) {
            log.info("user data insert success");
            return "redirect:/";
        } else {
            log.error("insert fail");
            return "CRUD/create";
        }
    }

    @GetMapping("/read")
    public String readPage(Model model) {
        model.addAttribute("userData", userService.readAllUser());
        return "CRUD/read";
    }


    @GetMapping("/delete")
    public String deletePage(Model model) {
        try {
            log.info("delete page load success");
            return "CRUD/delete";
        } catch (Exception e) {
            model.addAttribute("errorCdoe", 404);
            log.error("error " + e.getMessage());
            return ErrorPageFilter.errorPage;
        }
    }

    @PostMapping("/delete")
    public String delete(Model model, UserEntity user) {
        try {
            if (userService.Delete(user) == StatusDefine.SUCCESS) {
                log.info("delete success");
                return "redirect:/";
            } else {
                model.addAttribute("errorCdoe", 404);
                log.error(user.getEmail() + "delete fail");
                return ErrorPageFilter.errorPage;
            }
        } catch (Exception e) {
            log.error(user.getEmail() + "delete fail");
            return "CRUD/delete";
        }
    }
}
