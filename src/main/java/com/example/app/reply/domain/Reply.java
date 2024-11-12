package com.example.app.reply.domain;


import com.example.app.boardContent.domain.BoardContent;
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
    private String replyBy;
    @CreatedDate
    private LocalDateTime createdDate;
    private String replyTime;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "board_content_id", nullable = false)
    private BoardContent boardContent;
}
