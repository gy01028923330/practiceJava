package com.example.board.dto;


import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class BoardContentSearchCondition {

    private String title;
    private String content;
}
