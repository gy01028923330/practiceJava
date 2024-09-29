package com.example.board.repository;

import com.example.board.domain.Board;
import com.example.board.dto.BoardSearchCondition;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;

import java.util.List;

import static com.example.board.domain.QBoard.board;

@RequiredArgsConstructor
public class BoardRepositoryImpl implements BoardRepositoryCustom {

    private final JPAQueryFactory queryFactory;

    @Override
    public List<Board> findBoardWithCondition(BoardSearchCondition condition) {
        // JPQL, @Query 과 같은 JPA에서 기본으로 제공하는 SQL 작성 방법도 있지만
        // => querydsl 을 사용 한다.
        List<Board> fetch =
                queryFactory.select(board)
                        .from(board)
                        .where(
                                board.boardName.eq(condition.getBoardName()),
                                board.category.eq(condition.getCategory())
                        )
                        .fetch();
        return fetch;
    }
}
