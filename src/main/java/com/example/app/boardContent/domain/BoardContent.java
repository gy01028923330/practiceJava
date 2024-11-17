package com.example.app.boardContent.domain;

import com.example.app.board.domain.Board;
import com.example.app.boardContent.dto.BoardContentUpdateDto;
import com.example.app.member.domain.Member;
import com.example.app.reply.domain.Reply;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Table(name = "board_content")
@Entity
public class BoardContent {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    private String title;
    private String content;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "board_id", nullable = false)
    private Board board;
    @OneToMany(mappedBy = "boardContent", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Reply> replys = new ArrayList<>();
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id", nullable = false)
    private Member createdBy;

    public void updateFrom(BoardContentUpdateDto updateDto) {
        this.title = updateDto.getTitle();
        this.content = updateDto.getContent();
    }

}
