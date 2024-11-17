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
    private Board board;
    private Member createdBy;

}
