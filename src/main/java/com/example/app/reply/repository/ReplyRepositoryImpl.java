package com.example.app.reply.repository;

import com.example.app.reply.domain.Reply;
import com.example.app.reply.dto.ReplySearchCondition;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.util.StringUtils;

import java.util.List;

import static com.example.app.boardContent.domain.QBoardContent.boardContent;
import static com.example.app.reply.domain.QReply.reply;

@RequiredArgsConstructor
public class ReplyRepositoryImpl implements ReplyRepositoryCustom {
    private final JPAQueryFactory queryFactory;

    @Override
    public List<Reply> findReplyByCondition(ReplySearchCondition condition) {
        return queryFactory.select(reply)
                .from(reply)
                .where(
                        containReplyContent(condition.getReplyContent()),
                        containBoardContentId(condition.getBoardContentId()),
                        containMemberId(condition.getMemberId())
                )
                .orderBy(
                        reply.replyContent.asc(),
                        reply.id.desc()
                )
                .fetch();
    }

    public BooleanExpression containReplyContent(String replyContent) {
        return !StringUtils.hasText(replyContent) ? null : reply.replyContent.containsIgnoreCase(replyContent);
    }

    public BooleanExpression containContent(Long boardContentId) {
        return !StringUtils.hasText(boardContentId) ? null : boardContent.content.containsIgnoreCase(content);
    }
}
