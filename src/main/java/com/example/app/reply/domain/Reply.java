package com.example.app.reply.domain;


import com.example.app.boardContent.domain.BoardContent;
import com.example.app.member.domain.Member;
import jakarta.persistence.*;
import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
@Getter
@Entity
public class Reply {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "reply_id")
    private Long id;
    private String replyContent;
    @CreatedDate
    private LocalDateTime createdDate;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "board_content_id", nullable = false)
    private BoardContent boardContent;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id", nullable = false)
    private Member member;
}
