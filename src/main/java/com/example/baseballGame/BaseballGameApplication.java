package com.example.baseballGame;

import org.springframework.boot.SpringApplication;

//@SpringBootApplication
public class BaseballGameApplication {

	public static void main(String[] args) {
		SpringApplication.run(BaseballGameApplication.class, args);

		//9. 클래스의 기초
		/**
		 *  클래스란
		 *  자바의 객체지향언어의 특성을 살리기 위한 기본 구성요소
		 *
		 *  객체지향언어
		 *  	객체 : 사물이나, 실제 현실에서 사용되거나 개념적인 구성단위도 모두 객체라고 한다
		 *  	Ex. 자동차, 사람, 동물, 기계, 컴퓨터 / 급여, 어떤 물건의 생산과정, 통신
		 *  	통신 - 주파수, 사용하기 위한 대역 *번호 , 사용 금액, 관리하는 업체도
		 *  	내부 구성요소도 모두 객체로 판단할 수 있다.
		 *  	C , C++ , JAVA , python , ruby, ...etc 이게 모두 객체지향언어다
		 *
		 *   객체지향 언어르 제대로 사용하려면?
		 *   객체의 구성요소를 목적에 맞게 구분 짓고 사람이 이해할수 있는, 소통가능한 방식으로 표현을 해야한다.
		 *
		 *   Ex. 사람 -> BoardMember
		 *
		 *   주석이 없어도 변수명 or 메소드 명 or 인터페이스 명칭 과 같은걸 알아볼수 있게 하는게
		 *   => CleanCode
		 *	 변수 , 메소드명 과같은 이름을 지을 때 많은 고민을 해야한다.
		 *
		 *	생성자 메소드도 객체의 목적과 특성에 따라 제한을 둬야한다.
		 *
		 * 	Back-End 개발자의 주요 역량
		 *	1. 결과적으로 객체를 얼마나 잘 설계하느냐에 따라 개발자의 역량이 갈린다.
		 *	2. 객체를 활용하는 메소드를 얼마나 효율적이고 간소화 시켜서 사용을 하느냐.
		 *  new3. 편리함을 추구해야한다. 게을러지고 싶도록 노력해야해.
		 *
		 *  3. DataBase 설계 -> 자동완성 기능을 이용하여 간단하게 해소가 되는 시대가 왔다.
		 *	-----------------------------------
		 *  / ExCode
		 *  JPA 라이브러리의 어노테이션
		 *  -> 백엔드(서버)개발자가 DB를 따로 설정하지않아도 Java 코드만으로 DB의 모든 리소스를 제어할 수 있게하는 라이브러리
		 *
		 *
		 *  @Entity -> 현재 표시된 Class 의 구성요소들로 DataBase 를 구성해줘
		 *  -> JPA 라이브러리가 연결된 DB에 설정을 반영해서 Table 생성을 한다
		 *  @Table(name = "topup") -> Table 의 이름을 내가 임의로 지정하고싶어.
		 *
		 *
		 */

		//k5.setWheelNumber(3); // => 바퀴에 대한 setter가 열리면서 k5가 정해진대로 동작을 안할 수 가 있다.
		/**
		 * setter는 최대한 피한다. 라는 트렌드가 생겼어
		 * -> 불변객체 개념. 요거는 난이도가 있으므로 시간이 날때 한번 블로그 찾아봐서 따로 정리해두면 매우 좋음***
		 * ** @Builder : 불변객체를 구현하기 편리하게 만든 어노테이션(내부는 메소드로 구성되어있다)
		 * 자동완성 기능만 잘 쓸수 있으면 개발을 시작하기위한 진입장벽이 굉장히 낮아진다.
		 */

		// 자바의 메모리 모델
		/**
		 *  메모리 모델 관련해서 파고들면 한도끝도 없다.
		 *  책내용도 간단하게 읽고 넘어가고
		 *  Heap , Stack , ...etc 구성이 되어있지만
		 *
		 *  자세하게 몰라도 개발은 충분하게 가능하다.
		 *
		 * 현재 우리가 사용하고있는 Java 의 가장 큰 환경 요소중 하나가
		 * SpringFrameWork -> Spring -> Java 의 봄이 왔다고 해서 이름이 Spring
		 *
		 * Spring(+JVM) 이 메모리 영역, 또는 객체들간의 사용 순서를 위한
		 * 메모리상의 등록 및 삭제를 자체적으로 판단해서 효율적으로 쓰이게 만들어 준다.
		 * -> 개발자는 잘 몰라도 된다.
		 *
		 * 나중에 고도화된 작업 예를들면 성능을 개선시키거나(튜닝) 프로그램의 버그가 발생했을경우(매우매우 희박한 확률)에 알면 좋다.
		 * cause> Spring 의 완성도가 매우 높다
		 * 정부산업의 95%가 정부전자프레임워크라는 기술스택을 요구하는데 -> SpringFrameWork 을 살짝 이름바꿔서 만든거야.
		 * 정부에서 사용할정도? 안전성이 보장되었다 라고 볼수 있다.
		 *
		 * 결론.
		 * 	=> 객체의 관리는 크게 신경쓰지 않아도 된다.
		 * 	=>> 개발자는 사용의도와 사용 방법만 잘 설정해주면 된다.
		 *
		 *
		 *
		 */

		//스태틱의 이해
		/**
		 *  전역 설정이니, 전역 함수니, 메모리가 전역 메모리에 등록되었다.
		 *
		 *  내가 어떤 메소드 또는 객체를 사용하고 싶은데
		 *  1. Car k5 = new Car(); -> 이런 방식이 아니라
		 *  -> k5.getCompanyName();
		 *
		 *  바로 (회사이름 꺼내오기)
		 *  2. Car.getCompanyName(); 하기 위해서 'static' 을 쓴다.
		 *
		 *  차이점
		 *  -> 1. new 연산자를 통해 객체를 메모리 영역에 올린 뒤에야 객체의 내부 함수를 사용할 수 있다.
		 *  -> 2. 프로그램이 동작하자마자 메모리에 강제로 등록시키기 때문에 new 연산자 없이 객체에 직접 접근해 내부함수 사용가능.
		 *
		 *
		 *
		 */

		


	}

}


/**

 Architecture : 게시판 > 게시글
 Domain : 로마자로 나타낸 인터넷 사이트 주소 , 숫자로만 구성된 아이피(IP) 주소의 단점을 보완하기 위해 사용함.
 게시판 기능 == 카테고리
 a. 게시판 작성 -> 카테고리 생성 (Create)
 b. 게시판 조회 -> 카테고리 목록 출력
 c. 게시판 수정 -> 카테고리 명칭 변경
 d. 게시판 삭제 -> 카테고리에 포함되어있는 게시글 전체 삭제
 *
 게시글 기능
 게시글의 구성요소
 -> 제목, 내용, 작성자, 조회수, 댓글, 작성 일자, 수정 일자, 수정자(==작성자), 카테고리, 공개 여부, 좋아요, 해시태그
 A. 게시글 작성
 B. 게시글 조회 -> 게시글 목록 조회, 게시글 상세 조회.
 a. 게시글 목록 조회
 a-1. 조건 검색 [제목, 내용, 제목+내용, 작성자, 작성일자(범위)]
 a-2. 표시 항목 : [게시글번호, 게시글 제목, 작성자, 조회수, 댓글 수, 좋아요 수, 작성일자(<>수정일자)]
 a-3. 페이징 기능 (목록 하단에 게시글을 일정 수량 단위로 나눈 페이지의 갯수 출력)
 a-4. 정렬
 b. 게시글 상세 조회
 b-1. 표시 항목 : [제목, 내용, 작성자, 조회수, 댓글, 작성 일자, 수정 일자, 수정자(==작성자), 카테고리, 공개 여부, 좋아요, 해시태그]
 b-2. 댓글 (작성, 수정, 삭제)
 b-3. 좋아요 (Like, Unlike)
 C. 게시판 수정 -> 게시글 상세 내용 수정
 a. 수정 가능 항목 : [제목, 댓글, 내용, 카테고리, 해시 태그, 공개여부]
 D. 게시글 삭제 -> 게시글 단일 삭제
 *
 댓글 기능 (첫 댓글을 기준으로만 하위 댓글이 달리게 한다)
 A. 댓글 CRUD
 B. 대댓글 기능
 a. 대댓글
 ---------------- 고도화 기능 ---------------
 신고 기능
 A. 불량, 불법 게시글 신고처리.
 *
 통계 기능
 게시판(카테고리) 별 게시글 수
 전체 게시글 수
 게시판 별 조회 수
 신고 게시글 수
 */