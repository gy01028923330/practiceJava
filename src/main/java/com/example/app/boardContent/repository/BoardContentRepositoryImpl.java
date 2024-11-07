package com.example.app.boardContent.repository;

import com.example.app.boardContent.domain.BoardContent;
import com.example.app.boardContent.dto.BoardContentSearchCondition;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.util.StringUtils;

import java.util.List;

import static com.example.board.domain.QBoardContent.boardContent;

@RequiredArgsConstructor
public class BoardContentRepositoryImpl implements BoardContentRepositoryCustom {
    private final JPAQueryFactory queryFactory;

    @Override
    public List<BoardContent> findBoardContentByCondition(BoardContentSearchCondition condition) {
        return queryFactory.select(boardContent)
                .from(boardContent)
                .where(
                        containTitle(condition.getTitle()),
                        containContent(condition.getContent())
                )
                .orderBy(
                        boardContent.title.asc(),
                        boardContent.id.desc()
                )
                .fetch();
    }

    public BooleanExpression containTitle(String title) {
        return !StringUtils.hasText(title) ? null : boardContent.title.containsIgnoreCase(title);
    }

    public BooleanExpression containContent(String content) {
        return !StringUtils.hasText(content) ? null : boardContent.content.containsIgnoreCase(content);
    }

}