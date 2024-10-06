package com.example.board.repository;

import com.example.board.domain.Board;
import com.example.board.dto.BoardSearchCondition;

import java.util.List;

public interface BoardRepositoryCustom {
    List<Board> findBoardListByCondition(BoardSearchCondition condition);

}
