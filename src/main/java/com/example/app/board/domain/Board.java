package com.example.app.board.domain;


import com.example.app.board.dto.BoardUpdateDto;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.DynamicUpdate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@DynamicUpdate
@Builder
@Entity //DB에 table 을 해당 클래스 기준으로 생성
public class Board {

    /**
     * 게시판 카테고리
     * 게시판 제목
     */
    @Id @Column(name = "board_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // PK
    @Column
    private String boardName;
    @Column
    private String category;


    public void updateFrom(BoardUpdateDto requestDto) {
        this.boardName = requestDto.getBoardName();
        this.category = requestDto.getCategory();
    }

    //코드 => 자연어
    //컴퓨터 => 0,1 (2진수 - binary)
    // 위 두가지를 상호 변형하면서 프로그램이 동작 할 수 있게 해주는 녀석
    // 자바에서는 -> JVM
}
