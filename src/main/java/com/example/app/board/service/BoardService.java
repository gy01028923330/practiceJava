package com.example.app.board.service;


import com.example.app.board.domain.Board;
import com.example.app.board.dto.BoardResponseDto;
import com.example.app.board.dto.BoardSearchCondition;
import com.example.app.board.dto.BoardUpdateDto;
import com.example.app.board.repository.BoardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
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
/**
 * SELECT COUNT(*)
 * FROM board
 * WHERE board_name = '롤 게시판'
 */
        if (checkDuplicateBoardName(boardName))
            return;

        boardRepository.save(
                Board.builder()
                .boardName(boardName) // "테스트보드"
                .category(category)   // "테스트"
                .build()
        );

    }

    private boolean checkDuplicateBoardName(String boardName) {
        Long count = boardRepository.countDuplicateBoardName(boardName);
        return count > 0;
    }


    /**
     * 게시판 목록 조회 메소드
     */
    @Transactional(readOnly = true)
    public List<BoardResponseDto> findBoardList(BoardSearchCondition condition) {
        List<Board> boardList = boardRepository.findBoardListByCondition(condition);

        List<BoardResponseDto> boardResponseDtoList = new ArrayList<>();
        for (Board board : boardList) {
            boardResponseDtoList.add(BoardResponseDto.builder()
                    .boardId(board.getId())
                    .boardName(board.getBoardName())
                    .category(board.getCategory())
                    .build());
        }

        return boardResponseDtoList;
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

    public Board findById(Long id) {
        return boardRepository.findById(id).orElse(null);
    }

    @Transactional
    public void delete(Long id) {
        boardRepository.delete(findById(id));
    }

    public void update(Long id, BoardUpdateDto requestDto) {
        Board board = findById(id);
        board.updateFrom(requestDto);
    }
}
