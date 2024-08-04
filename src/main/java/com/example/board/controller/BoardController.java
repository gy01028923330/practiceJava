package com.example.board.controller;


import com.example.board.domain.Board;
import com.example.board.dto.BoardCreateRequestDto;
import com.example.board.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RequiredArgsConstructor //스프링에게 동작을 요청하기 위함
@RestController
public class BoardController {

    /**

     Controller 란 사용자의 화면, 즉 View 단과 맞닿아 있는 클래스(컴포넌트)
     -역할
     화면에서 전송되는 데이터를 전달받은 매개체
     서버(Back-end)에서 가공된 데이터를 화면으로 전달하는 매개체.
     */

    private final BoardService boardService;

    @PostMapping("/api/board")
    public String createBoard(@RequestBody BoardCreateRequestDto requestDto) {

        boardService.create(requestDto.getBoardName(), requestDto.getCategory());
        return "게시판 생성 완료 OR 에러";
    }
}
