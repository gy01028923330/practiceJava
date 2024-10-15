package com.example.board.service;


import com.example.board.domain.Board;
import com.example.board.dto.BoardResponseDto;
import com.example.board.dto.BoardSearchCondition;
import com.example.board.repository.BoardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


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
//        Board build = Board.builder()
//                .boardName(boardName) // "테스트보드"
//                .category(category)   // "테스트"
//                .build();
//        boardRepository.save(build);

        boardRepository.save(
                Board.builder()
                .boardName(boardName) // "테스트보드"
                .category(category)   // "테스트"
                .build()
        );

    }


    /**
     * 게시판 목록 조회 메소드
     */
    @Transactional(readOnly = true)
    public List<BoardResponseDto> findBoard(BoardSearchCondition condition) {
        List<Board> boardList = boardRepository.findBoardListByCondition(condition);

        //숙제1.  위 boardList 를 List<BoardResponseDto> 만들어서 return 하시오.
        //숙제2. 목록조회 API가 완성되었는데 querydsl 부분을 분석 및 설명 하시오. 상세하게 전체적으로
        // => BoardRepositoryImpl.findBoardListByCondition()
        return null;
    }

    /**
     * 게시판 상세 조회 메소드
     */
    @Transactional(readOnly = true)
    public BoardResponseDto getBoardById(Long id) throws Exception {
        Board board = boardRepository.findById(id).orElseThrow(() -> new Exception("조회 실패"));

        return BoardResponseDto.builder()
                .boardId(board.getId())
                .boardName(board.getBoardName())
                .category(board.getCategory())
                .build();

        //OSIV -> Open Session In View (On/off)
        //board.setBoardName("박성술"); //영속성이 살아있는 상태에서만 더티체킹 -> update쿼리 발생.
    }

    public void delete(Long id) {

    }

    public void update(Long id, String boardName, String category) {

    }
}
