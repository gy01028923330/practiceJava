package com.example.app.reply.repository;

import com.example.app.reply.domain.Reply;
import com.example.app.reply.dto.ReplySearchCondition;

import java.util.List;

public interface ReplyRepositoryCustom {

    List<Reply> findReplyByCondition(ReplySearchCondition condition);

}
