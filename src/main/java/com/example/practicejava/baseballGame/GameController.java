package com.example.practicejava.baseballGame;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class GameController {

    @Autowired
    private GameService gameService;

    @GetMapping("/")
    public String index() {
        gameService.generateNumbers();
        return "index";
    }

    @PostMapping("/guess")
    public String guess(@RequestParam("inputNumber") String inputNumber, Model model) {
        String result = gameService.checkGuess(inputNumber);
        model.addAttribute("result", result);
        return "index";
    }
}
