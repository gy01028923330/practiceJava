package com.example.board.domain;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.web.bind.annotation.PostMapping;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity //DB에 table 을 해당 클래스 기준으로 생성
public class Board {

    /**
     * 게시판 카테고리
     * 게시판 제목
     *
     */
    private String boardName;
    private String category;
    @Id
    private Long boardId;



}
