package com.example.board.repository;

import com.example.board.domain.Board;
import com.example.board.dto.BoardSearchCondition;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.util.StringUtils;

import java.util.List;

import static com.example.board.domain.QBoard.board;


@RequiredArgsConstructor
public class BoardRepositoryImpl implements BoardRepositoryCustom {

    private final JPAQueryFactory queryFactory;

    @Override
    public List<Board> findBoardListByCondition(BoardSearchCondition condition) {

        List<Board> list = queryFactory.select(board)
                .from(board)
                .where(
                        likeBoardName(condition.getBoardName()),
                        likeCategory(condition.getCategory())
                )
                .orderBy(
                        board.boardName.asc(),
                        board.id.desc()
                ).fetch();

        return list;
    }

    //동적 쿼리 작성 메소드
    public BooleanExpression likeBoardName(String boardName) {
        if (StringUtils.hasText(boardName)) {
            return null;
        }
        return board.boardName.containsIgnoreCase(boardName);
    }

    public BooleanExpression likeCategory(String category) {
        if (StringUtils.hasText(category)) {
            return null;
        }
        return board.category.containsIgnoreCase(category);
    }


}
