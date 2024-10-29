package com.example.board.repository;

import com.example.board.domain.BoardContent;
import com.example.board.dto.BoardContentSearchCondition;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class BoardContentRepositoryImpl implements BoardContentRepositoryCustom {
    private final JPAQueryFactory queryFactory;

    @Override
    public List<BoardContent> findByBoardContentIdByCondition(BoardContentSearchCondition condition) {
        return List.of();
    }
}
