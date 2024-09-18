package com.example.board.domain;

import com.example.member.domain.Member;
import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.ManyToAny;

import java.time.LocalDateTime;

@Data
@Table(name = "board_content")
@Entity
public class BoardContent {

    @Id
    private Long id;


    private String title;
    private String content;
    private Integer viewCount;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private LocalDateTime deletedAt;
    private Boolean isOpened;
    private String hashtag;




}
