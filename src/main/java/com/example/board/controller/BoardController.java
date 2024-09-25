package com.example.board.controller;


import com.example.board.domain.Board;
import com.example.board.dto.BoardCreateRequestDto;
import com.example.board.dto.BoardSearchCondition;
import com.example.board.service.BoardService;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


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

    @PostMapping("/api/board")
    public String createBoard(@RequestBody BoardCreateRequestDto requestDto) {

        boardService.create(requestDto.getBoardName(), requestDto.getCategory());

        // 개발 주도권을 스프링 프레임워크에게 일임
        // -> 의존 한다.
        // Spring Frame WorK의 3가지 주요 기능
        // -> 1. IOC -> Inversion Of Control 제어의 역전.
        // -> 2. DI -> Dependency Injection 의존성 주입.
            // DI의 장점 . Bean 으로 등록된 객체가 사용 하는 시점에 인스턴스화 시킨다.
            // => 메모리의 효율성 증가.
        // -> 3. AOP -> Aspect(시간의 점) Oriented Programming

        return "게시판 생성 완료";
    }

    /**
     * 게시판 목록 조회 API
     */
    @GetMapping("/api/board")
    public String findBoard(@ModelAttribute BoardSearchCondition condition) {

        String result = boardService.findBoard(condition);

        return "게시판 정보 : " + result;
    }

}
