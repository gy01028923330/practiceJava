package com.example.practicejava.baseballGame;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DemoController {

    @GetMapping("/login")
    public String showLoginForm() {
        return "login";
    }
}

