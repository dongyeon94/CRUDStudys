package com.example.root.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@Slf4j
public class MainIndex {

    @GetMapping("/")
    public String main() {
        log.info("main page load successs");
        return "index";
    }
}
