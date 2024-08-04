package com.example.practicejava;

import com.example.practicejava.family.Family;
import com.example.practicejava.family.Person;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

//@SpringBootApplication
public class PracticeJavaApplication {
    public static void main(String[] args) {
        /**
         *  - DB실행순서
         *  1. main 메소드 실행
         *  2. url에 localhost:8080/h2-console 접속
         *  3. JDBCUrl에 'jdbc:h2:mem:test' 입력 되었는지확인
         *  4. ID : sa
         *  5. Pwd : 없음
         *  6. connect 버튼 클릭
         *
         *  BoardMember Table 생성 query
         *  CREATE TABLE member
         * (   member_id      VARCHAR2(100)     NOT NULL,
         *     member_name    VARCHAR2(100)     NOT NULL,
         *     gender         VARCHAR2(10)      NULL,
         *     age         NUMBER               NULL,
         *     hire_date   DATE                 NULL,
         *     etc         VARCHAR2(300)        NULL,
         *     PRIMARY KEY (member_id)                  );
         *
         *     회원 5개 각각 다르게 DB insert -> SQL insert 문 검색
         *     하고 5개 조회 성공까지 캡처
         *
         */
        //스프링부트 실행 함수
        //SpringApplication.run(PracticeJavaApplication.class, args);
 //   Calculator.calculate(3,4,"+"); //자바에서는 클래스명을 제외한 모든구성요소는 소문자로 시작한다.
        //객체의 함수를 호출하려면 메모리에 등록이 되어있어야된다
        //조건1 전역함수를 사용하지 않고 계산함수를 호출
        //조건2 조건1을 완성시킨뒤 전역함수로 calculate2를 만들어서 똑같이 호출
        //계산기 예제코드 따라치기


        Person person = new Person();
        person.setName("김진규");
        person.setAge(18);
        person.setSex("male");
        person.setAddress("운정");

        Person person1 = new Person("김지아", 15, "female", "운정");

        List<Person> personList = new ArrayList<>();
        // 배열 -> '<>' 안에 들어가는것은 Generic이라고 한다.
        // 제네릭은 리스트에 들어갈 객체를 지정해주는것.
        personList.add(person);
        personList.add(person1);
        System.out.println(personList.get(0));
        Family family1 = new Family(4,"진규네",false,"son",personList);
        System.out.println(family1);


        System.out.println(person.totalFamily());


    }
}

