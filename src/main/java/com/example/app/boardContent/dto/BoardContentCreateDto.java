package com.example.app.boardContent.dto;


import com.example.app.board.domain.Board;
import com.example.app.member.domain.Member;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class BoardContentCreateDto {

    private String title;
    private String content;
    private Long boardId;
    private Long createdMemberId;

    /**
     * frontEnd
     *
     * 1번 게시판 글을 작성 중인 상황
     *
     * fetch.POST("~/api/board-content").body(
     *  object : {
     *  "title" : "요네 분석",
     *  "content" : "사기꾼",
     *  "boardId" : "1"
     *
     * )
     *
     *
     *
     */

}
