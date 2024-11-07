package com.example.app.board.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@AllArgsConstructor
@Builder
@Data
public class BoardResponseDto {

    private Long boardId;

    private String boardName;

    private String category;
}
