package com.example.app.boardContent.repository;

import com.example.app.boardContent.domain.BoardContent;
import com.example.app.boardContent.dto.BoardContentSearchCondition;

import java.util.List;

public interface BoardContentRepositoryCustom {
    List<BoardContent> findBoardContentByCondition(BoardContentSearchCondition condition);
}
