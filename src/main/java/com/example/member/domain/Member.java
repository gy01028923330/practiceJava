package com.example.member.domain;


import lombok.*;

@ToString
@Getter
@Setter
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
public class Member {

    private String Id;
    private String password;
    private String name;
    private String gender;
    private Integer age;

    /**
     *  접근제한자를 private으로 초기 세팅하는 이유
     *  1. 외부에 접근을 제한 함으로써 개발자의 Human error를 최소화 하기 위해.
     *  2. 기능상 외부의 접근 허용 범위를 판단하기 어렵기 때문에 최소한의 접근 기능만 부여한다.
     *  -> 필요시에 점차적인 확장을 허용한다. private -> protected -> public
     */
}
