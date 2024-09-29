package com.example.board.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class BoardUpdateRequestDto {

    private String boardName;
    private String category;


}
