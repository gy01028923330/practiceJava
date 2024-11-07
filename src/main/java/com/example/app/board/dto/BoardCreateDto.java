package com.example.app.board.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BoardCreateDto {
    /** DTO : Data Transfer Object -> 데이터를 전달하는 객체
     *  전달하려는 데이터의 종류
     *      1. 사용자로부터 받은 데이터
     *      2. 서버에서 가공된 데이터
     *      3. DB 에서 넘어온 데이터
     */

    private String boardName;
    private String category;

}
