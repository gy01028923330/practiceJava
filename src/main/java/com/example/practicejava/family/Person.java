package com.example.practicejava.family;


import lombok.*;
@ToString
@AllArgsConstructor //클래스 변수를 모두 지정하는 생성자 함수
@NoArgsConstructor //파라미터가 없는 생성자 함수 -> 기본 생성자
@Setter
@Getter
public class Person extends Family{ // extends는 객체가 상속받을 대상클래스를 정하는 방법.

    private String name;
    private Integer age;
    private String sex;
    private String address;
}
