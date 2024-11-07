package com.example.app.boardContent.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class BoardContentUpdateDto {

    private String title;
    private String content;
}
