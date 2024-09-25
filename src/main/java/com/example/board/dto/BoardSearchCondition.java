package com.example.board.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class BoardSearchCondition {

    private String boardName;

    private String writer;

    private String category;

}
