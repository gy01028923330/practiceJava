package com.example.app.board.repository;

import com.example.app.board.domain.Board;
import com.example.app.board.dto.BoardSearchCondition;

import java.util.List;

public interface BoardRepositoryCustom {
    List<Board> findBoardListByCondition(BoardSearchCondition condition);

    Long countDuplicateBoardName(String boardName);



}
