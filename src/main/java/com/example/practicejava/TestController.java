package com.example.practicejava;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class TestController {
    @GetMapping("/test")
    public List<LolItem> testHelloWorld() {

        LolItem item1 = new LolItem("도란방패");
        LolItem item2 = new LolItem("도란방패");
        LolItem item3 = new LolItem("도란방패");
        LolItem item4 = new LolItem("도란방패");
        LolItem item5 = new LolItem("도란방패");
        LolItem item6 = new LolItem("도란방패");
        List<LolItem> items = new ArrayList<>();

        items.add(item1);
        items.add(item2);
        items.add(item3);
        items.add(item4);
        items.add(item5);
        items.add(item6);
        return items;

    }
}
