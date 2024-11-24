package com.example.app.board.repository;

import com.example.app.board.domain.Board;
import com.example.app.board.dto.BoardSearchCondition;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.util.StringUtils;

import java.util.List;

import static com.example.app.board.domain.QBoard.board;


@RequiredArgsConstructor
public class BoardRepositoryImpl implements BoardRepositoryCustom {

    private final JPAQueryFactory queryFactory;

    @Override
    public List<Board> findBoardListByCondition(BoardSearchCondition condition) {

        return queryFactory.select(board)
                .from(board)
                .where(
                        likeBoardName(condition.getBoardName()),
                        likeCategory(condition.getCategory())
                )
                .orderBy(
                        board.boardName.asc(),
                        board.id.desc()
                ).fetch();
    }

    @Override
    public Long countDuplicateBoardName(String boardName) {
        return null;
    }

    //동적 쿼리 작성 메소드
    public BooleanExpression likeBoardName(String boardName) {
        return !StringUtils.hasText(boardName) ? null : board.boardName.containsIgnoreCase(boardName);
    }

    public BooleanExpression likeCategory(String category) {
        if (!StringUtils.hasText(category)) {
            return null;
        }
        return board.category.containsIgnoreCase(category);
    }

}
