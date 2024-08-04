package com.example;


import lombok.RequiredArgsConstructor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@RequiredArgsConstructor
@SpringBootApplication
public class BoardApplication {


    public static void main(String[] args) {
        //스프링부트 실행 함수
        SpringApplication.run(BoardApplication.class, args);
    }
}
//
//        MemberService memberService = new MemberService();
//        /**
//
//         문제
//         총 가입되는 회원은 5명
//         회원의 정보를 sout 으로 출력한다.
//         중복검사는 아이디와 이름 2가지가 모두 기존 회원 정보와 달라야 가입된다.
//         결과는 1번, 2번 ,4번 회원만 가입되어야 한다.
//         *///전체 가입된 회원 목록
//        List<Member> completeMember = new ArrayList<>();
//
//        //1번 회원
//        //Controller 에서 받아온 데이터로 가정
//        Member member = new Member();
//        String id = "member1";
//        String password = "1234";
//        String name = "김진규";
//        Member member1 = new Member(id, password, name, "남", 18);
//        //2번 회원
//        String id2 = "member2";
//        String password2 = "1234";
//        String name2 = "박성술";
//        Member member2 = new Member(id2, password2, name2, "남", 19);
//        //3번 회원
//        String id3 = "member3";
//        String password3 = "1234";
//        String name3 = "김지아";
//        Member member3 = new Member(id3, password3, name3, "여", 17);
//        //4번 회원
//        String id4 = "member4";
//        String password4 = "1234";
//        String name4 = "김태희";
//        Member member4 = new Member(id4, password4, name4, "여", 20);
//        //5번 회원
//        String id5 = "member5";
//        String password5 = "1234";
//        String name5 = "카리나";
//        Member member5 = new Member(id5, password5, name5, "여", 21);
//
//
//        completeMember = memberService.createMember(member1, completeMember);
//        completeMember = memberService.createMember(member2, completeMember);
//        completeMember = memberService.createMember(member3, completeMember);
//        completeMember = memberService.createMember(member4, completeMember);
//        completeMember = memberService.createMember(member5, completeMember);
////        ---------------------------create--------------------------------
//
//        System.out.println(completeMember.toString());
//
//        List<Member> findResults = new ArrayList<>();
//
//        findResults = memberService.searchMemberByGender(completeMember, "남");
//
//        System.out.println(findResults);
//
//        findResults = memberService.searchMemberByGender(completeMember, "여");
//
//        System.out.println(findResults);
//
//        List<Member> findResults2 = new ArrayList<>();
//        findResults2 = memberService.searchMemberByGenderAndAge(completeMember, "여", 19, 20);
//        System.out.println(findResults2);
//
//        String inputId;
//        String inputPassword;
//
//        Scanner sc = new Scanner(System.in);
//        System.out.println("회원 ID를 입력하세요");
//        inputId = sc.next();
//        System.out.println("회원 비밀번호를 입력하세요");
//        inputPassword = sc.next();
//
//        Member findedMember = memberService.findMember(completeMember, inputId);
//
//        if (findedMember == null) {
//            System.out.println("일치하는 회원이 없습니다.");
//            return;
//        }
//
//        Boolean login = memberService.login(findedMember, inputId, inputPassword);
//
//        if (login) {
//            System.out.println("로그인");
//        } else {
//            System.out.println("로그인에 실패했습니다.");
//            return;
//        }
////      --------------------------------read-------------------------
//        System.out.println("변경 할 비밀먼호를 입력");
//        String inputChangePassword = sc.next();
//        System.out.println("변경 할 이름을 입력");
//        String inputChangeName = sc.next();
//        System.out.println("변경 할 성별을 입력");
//        String inputChangeGender = sc.next();
//        System.out.println("변경 할 나이를 입력");
//        Integer inputChangeAge = sc.nextInt();
//
//
//        Member updatedMember = memberService.updateMember(findedMember, inputChangePassword, inputChangeName, inputChangeGender, inputChangeAge);
//        completeMember = memberService.save(completeMember, updatedMember);
//        System.out.println("수정 완료");
////      ----------------------update---------------------
//
//        completeMember = memberService.deleteMember(completeMember, findedMember);


        //여기 main 메소드에서 searchMemberByGender 메소드를 호출
        // 1번째 호출 시 남자 회원만 적용 후 sout 출력
        // 2번째 호출 시 여자 회원만 적용 후 sout 출력



//한꺼번에 변경하는 단축키 => Shift+F6
//completeMember 라는 회원 배열객체를 만든 이유 => 가입된 회원을 정리하기 위해서.
/**
 * Product : 회원 가입 리스트
 * 목적 -> 중복검사를 통과한 회원의 리스트를 출력.
 * 최종적으로 System.out.println(completeMember.toString());
 */

//아래 상황에서는 회원이 딱 2명까지만 중복검사가 이뤄진다. => 코드 변경 필요!


/**

 메소드 오버로딩 - Overloading
 같은 이름의 메소드의 파라미터 갯수만 다르게 하여 기능을 확장 하는것.*
 메소드 오버라이딩 - Override
 부모관계의 객체의 메소드를 상속받아 '재정의'하여 기능을 확장 하는것.
 단 이름, 반환 타입, 파라미터 갯수는 부모의 메소드와 동일하여야 한다.**
 SOLID 원칙 -> 객체 지향 설계의 5가지 원칙
 S (SRP, Single Responsibility Principle) 단일 책임 원칙
 -> 하나의 클래스 또는 하나의 메소드는 한가지의 책임만 가져야 한다.
 -> 클래스 또는 메소드의 역할을 작은 단위로 나누어야 한다.
 => 추후 유지보수성이 높아진다.
 O (OCP, Open-Closed Principle) 개방-폐쇄 원칙
 -> 객체(프로그램 or 소프트웨어)의 요소는 확장에는 열려있으나 변경에는 닫혀있어야 한다.
 -> 기본적으로 기존의 코드(ex.객체의 변수)를 변경하지 않고 기능을 수정 또는 확장할 수 있어야 한다.
 -> 메소드 오버로딩 , 오버라이딩, [Builder 패턴 - 불변 객체]
 *
 L (LSP, Liskov Substitution Principle) 리스코프 치환 원칙
 -> 자식 객체는 부모 객체에서 사용하는 동작을 실행할 수 있어야한다.
 -> 상속 기능을 이용하면 필수적으로
 I (ISP, Interface Segregation Principle) 인터페이스 분리 원칙
 -> 사용자는 자신이 이용하는 메소드에만 의존해야된다.
 => 사용자는 프로그램을 사용하는 목적이 있지.
 Ex. 자동차를 구매하려는 사용자다.
 자동차 종류를 알아야하고
 자동차 종류별 검색
 구매를 확정.
 대금을 지급.
 자동차를 수령.
 -> DB를 사용하게하거나 , 특정 코드를 생성해서 이용하는 것이 아니라.
 -> 메소드만 이용하게 한다.
 ==> 사용하게 될 RestApi 를 이용한다면 지켜진다.
 //* tradeOff -> 딜레마. 어느걸 써야 좋은지 여러 의견간의 장단점 중에 선택을 해야하는 경우.
 D (DIP, Dependency Inversion Principle) 의존 역전 원칙
 -> 1. 구체화에 의존하면 안되고, 추상화에 의존해야 된다.
 => Ex. SpringFramework 의 대표적인 기능 3가지
 DI - Dependency Injection : 의존성 주입
 IOC - Inversion Of Control : 제어의 역전
 AOP - Aspect Oriented Programming - 관점 지향 프로그래밍.(이걸 가능하게 해준다)
 -> 위와 같은 SpringFramework의 기능을 사용하면서 원칙에 매우 근접하게 지켜진다.
 -> 2. 저수준 모듈이 변경되어도 고수준 모듈은 변경이 필요없는 형태가 되어야한다.
 -> 중복검사를 하는데 , //한자 검사기능까지 넣어야하는가?
 */