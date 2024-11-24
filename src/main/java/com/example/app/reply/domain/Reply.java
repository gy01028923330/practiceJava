package com.example.app.reply.domain;


import com.example.app.boardContent.domain.BoardContent;
import com.example.app.member.domain.Member;
import com.example.app.reply.dto.ReplyUpdateDto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;

import java.time.LocalDateTime;
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Table(name = "reply")
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

    public void updateFrom(ReplyUpdateDto updatedDto){
        this.replyContent = updatedDto.getReplyContent();
        this.boardContent = updatedDto.getBoardContent.getId();
        this.member = updatedDto.getMember.getId();
    }
}
