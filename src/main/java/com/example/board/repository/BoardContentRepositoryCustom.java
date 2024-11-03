package com.example.board.repository;

import com.example.board.domain.BoardContent;
import com.example.board.dto.BoardContentSearchCondition;

import java.util.List;

public interface BoardContentRepositoryCustom {
    List<BoardContent> findBoardContentByCondition(BoardContentSearchCondition condition);
}
