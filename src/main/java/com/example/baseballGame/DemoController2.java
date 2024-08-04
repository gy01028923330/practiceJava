package com.example.baseballGame;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController2 {

    @GetMapping("/test2")
    public String test2() {
        return "test2";
    }

}
