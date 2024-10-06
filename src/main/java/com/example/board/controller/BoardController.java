package com.example.board.controller;


import com.example.board.dto.BoardCreateRequestDto;
import com.example.board.dto.BoardResponseDto;
import com.example.board.dto.BoardSearchCondition;
import com.example.board.dto.BoardUpdateRequestDto;
import com.example.board.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RequiredArgsConstructor //스프링에게 동작을 요청하기 위함
@RestController //-> Bean 으로 등록 한다.
public class BoardController {

    /**
     * Spring frame work -> 틀 안에서 일을 하게끔 도와 준다.
     *
     * 빈(Bean)은 스프링 컨테이너에 의해 관리 되는 재사용 가능한 소프트웨어 컴포넌트이다.
     * 즉, 스프링 컨테이너가 관리하는 자바 객체를 뜻하며, 하나 이상의 빈(Bean)을 관리한다.
     * 빈은 인스턴스화된 객체를 의미하며, 스프링 컨테이너에 등록된 객체를 스프링 빈이라고 한다.
     */

    /**
     Controller 란 사용자의 화면, 즉 View 단과 맞닿아 있는 클래스(컴포넌트)
     -역할
     화면에서 전송되는 데이터를 전달받은 매개체
     서버(Back-end)에서 가공된 데이터를 화면으로 전달하는 매개체.
     */

    private final BoardService boardService;

    // 게시판 생성
    @PostMapping("/api/board")
    public ResponseEntity<String> createBoard(@RequestBody BoardCreateRequestDto requestDto) {
        boardService.create(requestDto.getBoardName(), requestDto.getCategory());
        return ResponseEntity.ok("게시판 생성 완료");
    }
    // DB, 사용자
    // 1. 게시판 목록 조회
    @GetMapping("/api/board")
    public ResponseEntity<List<BoardResponseDto>> getBoard(@ModelAttribute BoardSearchCondition condition) {
        List<BoardResponseDto> board = boardService.findBoard(condition);
        return ResponseEntity.ok(board);
    }

    // 2. 게시판 상세 조회
    @GetMapping("/api/board/{id}")
    public String getBoardDetail(@PathVariable Long id, Model model) throws Exception {
        BoardResponseDto board = boardService.getBoardById(id);
        model.addAttribute("board", board);
        return "board-detail";
    }

    // 게시판 수정
    @PutMapping("/api/board/{id}")
    public ResponseEntity<String> updateBoard(@PathVariable Long id, @RequestBody BoardUpdateRequestDto requestDto) {
        boardService.update(id, requestDto.getBoardName(), requestDto.getCategory());
        return ResponseEntity.ok("게시판 수정 완료");
    }

    // 게시판 삭제
    @DeleteMapping("/api/board/{id}")
    public ResponseEntity<String> deleteBoard(@PathVariable Long id) {
        boardService.delete(id);
        return ResponseEntity.ok("게시판 삭제 완료");
    }

}
