package com.example.board.controller;

import com.example.board.dto.BoardCreateRequestDto;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BoardViewController {

    @GetMapping("/")
    public String index() {
        return "index";  // index.html을 렌더링
    }

    @GetMapping("/create")
    public String createBoardForm(Model model) {
        model.addAttribute("boardCreateRequestDto", new BoardCreateRequestDto());
        return "create";
    }

    @GetMapping("/view")
    public String viewBoardForm(Model model) {
        // 추가적인 로직 필요
        return "view";
    }

    @GetMapping("/update")
    public String updateBoardForm(Model model) {
        // 추가적인 로직 필요
        return "update";
    }

    @GetMapping("/delete")
    public String deleteBoardForm(Model model) {
        return "delete";
    }
}
