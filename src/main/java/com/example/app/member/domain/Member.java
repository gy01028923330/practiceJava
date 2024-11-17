package com.example.app.member.domain;


import com.example.app.boardContent.domain.BoardContent;
import com.example.app.reply.domain.Reply;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String password;
    private String name;
    private String gender;
    private Integer age;
    @OneToMany(mappedBy = "member", cascade = CascadeType.ALL)
    private List<BoardContent> boardContents = new ArrayList<>();
    @OneToMany(mappedBy = "member", cascade = CascadeType.ALL)
    private List<Reply> replys = new ArrayList<>();

    /**
     *  접근제한자를 private으로 초기 세팅하는 이유
     *  1. 외부에 접근을 제한 함으로써 개발자의 Human error를 최소화 하기 위해.
     *  2. 기능상 외부의 접근 허용 범위를 판단하기 어렵기 때문에 최소한의 접근 기능만 부여한다.
     *  -> 필요시에 점차적인 확장을 허용한다. private -> protected -> public
     */
}
