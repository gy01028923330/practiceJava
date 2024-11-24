package com.example.app.reply.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class ReplyUpdateDto {
    private String replyContent;
    private Long boardContentId;
    private Long memberId;
}
