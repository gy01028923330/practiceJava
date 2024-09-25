package com.example.board.service;


import com.example.board.controller.BoardController;
import com.example.board.domain.Board;
import com.example.board.repository.BoardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class BoardService {



    private final BoardRepository boardRepository;

    /**
     * Service 란 Controller 에서 전달받은 데이터를 기반으로 서비스로직을 구현하는 클래스(컴포넌트)
     * 역할
     * 1. 사용자에게 제공되어야 하는 기능(API)을 작성하는 실질적인 부분
     * 2. DB 에서 받아온 데이터를 가공하여 기능에 사용하기 적합하도록 만드는 부분
     * 3. 에러가 발생 할 경우 이를 처리하는 부분 (프로젝트 전략에 따라 다를 수 있다)
     */


    @Transactional
    public void create(String boardName, String category) {
        // DB의 SQL 을 정의 하는 세가지 종류
        // DDL, DML, DCL
        // create 문 -> Table 생성.
        // insert 문 -> Table 내부 Row data 를 생성 한다.
        // ->  DML문을 사용할 때, commit 명령어를 사용해야 DB에 정상적으로 저장 된다.
        // --> commit을 사용하는 이유 => Transaction 단위로 DB가 동작하기 때문.
        boardRepository.save(
                Board.builder()
                        .boardName(boardName) // "테스트보드"
                        .category(category)   // "테스트"
                        .build()
        );
        // insert into board values (1, "테스트보드", "테스트")
    }

}
