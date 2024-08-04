package com.example.board.domain;

import com.example.member.domain.Member;

import java.time.LocalDateTime;

public class BoardContent {

    private Board board;
    private String title;
    private String content;
    private Integer viewCount;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private LocalDateTime deletedAt;
    private Member createdBy;
    private Member updatedBy;
    private Member deletedBy;
    private Boolean isOpened;
    private String hashtag;




}
