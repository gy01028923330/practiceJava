package com.example.app.reply.dto;


import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class ReplySearchCondition {
    private String replyContent;
    private Long boardContentId;
    private Long memberId;
}
