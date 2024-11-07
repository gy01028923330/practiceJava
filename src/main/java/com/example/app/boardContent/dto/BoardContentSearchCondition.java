package com.example.app.boardContent.dto;


import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class BoardContentSearchCondition {

    private String title;
    private String content;
}
