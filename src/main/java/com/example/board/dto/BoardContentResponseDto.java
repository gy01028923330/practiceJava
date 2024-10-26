package com.example.board.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@AllArgsConstructor
@Builder
@Data
public class BoardContentResponseDto {
    private Long boardContentId;
    private String title;
    private String content;
}
