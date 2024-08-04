package com.example.practicejava.family;

import lombok.ToString;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.*;

//@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
//		SpringApplication.run(DemoApplication.class, args);

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

		/**
		 * 패키지와 클래스패스
		 * - 가장 중요하게 봐야할것은
		 * => Class 파일의 소스중 최상단에 있는 'package com.example.address' 모양의 경로를 인식
		 * 1. 개발자가 주로 해당 클래스파일에 접근하는 방법
		 * 	- cmd / 커널 (OS = { 'Windows' , 'Linux' } 두개 중 Linux 를 많이 사용하게 된다)
		 * 	--> Linux 가 오픈소스 기반의 자료들이 많기 때문에. 편리하다.
		 * 	- IDEA (개발 tool)
		 * 	- 탐색기(Explorer)
		 *
		 */

		/**
		 * String 은 Wrapper Class 처럼 객체가 존재하지만. 원시타입으로 분류하기도 한다. (primitive)
		 *
		 * 배열 (*****)
		 * - 보편적으로 많은 데이터를 처리하려고 할때 가장 많이 사용된다.
		 * - 배열 자체에 채번(순번 생성)되기 때문에 활용도가 높다.
		 * 배열을 표기하는 방법으로
		 * Ex) String 배열을 자료형으로 표기한다면? -> String[] array = new String[2]
		 *
		 */

		String[] array = new String[4]; // 길이를 지정할때의 숫자는 갯수를 의미.
		String[] array2 = {"박성술",null,"김형술"}; // 길이를 지정할때의 숫자는 갯수를 의미.
		System.out.println(array2[2]);
		// 4는 해당 배열의 길이를 나타낸다.
		array[0] = "박성술";
		array[1] = "김진규";
		array[3] = "김형술";
		System.out.println(array[2]);

		String[] employeeArray = new String[100];
		//0~9 까지 10명의 사원을 회사에서 받았다.
		// -> 추가적인 사원을 받고싶을때 해결방법?
		/**
		 *  여기서 확인 가능한 문제점 *
		 *  - 기존 자료형의 배열만으로는 기술적으로 불편함이 존재한다.
		 *  # 이를 해결하기 위해 나온 배열형 자료형이 [List, Set]

		 *
		 */

		List<Car> carList = new ArrayList<>();
		Car a = new Car("중형a","k5");
		Car b = new Car("소형b","모닝");
		Car c = new Car("대형c","그랜저");

		carList.add(a);
		carList.add(b);
		carList.add(c);
		carList.add(a);


//		for (Car car : carList) { //향상 for 문
//			System.out.println(car);
//		}

		/**
		 * HashSet 과 TreeSet 은 내부 정렬을 지원하지 않고
		 * 각각 정해진 알고리즘에 따라 내부 순번을 정한다.
		 *
		 * HashSet 은 객체의 주솟값으로 내부 순번을 정함.
		 * TreeSet 은 2진 트리구조로 내부 순번을 정함.
		 *
		 * LinkedHashSet 은 중복제거와 동시에 내부 순번까지 정해지는 Set 을 상속받은 자료형.
		 *
		 */
		Set<Car> carSet = new HashSet<>();
		Set<Car> carSet2 = new TreeSet<>();
		Set<Car> carSet3 = new LinkedHashSet<>();

		carSet.add(a);
		carSet.add(b);
		carSet.add(c);
		carSet.add(a);
		System.out.println("-------------------------------------");
		for (Car car : carSet) {
			System.out.println(car);
		}

		System.out.println("-------------------------------------");
		System.out.println(carSet);
		System.out.println(carList.get(0));
		/**
		 *  List 와 Set 모두 배열형 자료형이지만
		 *  결정적인 차이는
		 *  - List 는 내부데이터의 중복을 허용
		 *  - Set 은 내부데이터의 중복을 허용 X
		 *  => Set 은 중복제거를 위해 내부적으로 순번이 입력이 안된다.
		 */

		/**
		 * 	 *  실무에서 가장 많이 쓰는 배열 형태는
		 *   *  => ArrayList
		 *
		 *   ## ArrayList 의 내부 메소드
		 *   - add(Object) : 객체 추가
		 *   - get(n) : 특정 index 의 객체를 조회
		 *   - remove(n) : 특정 index 의 객체를 삭제
		 *   - size() : return 값 = 배열의 길이
		 *   - isEmpty() : 배열이 비어있는지 확인하는 메소드
		 *   - contains(Object) : 파라미터의 객체가 포함되어있는지 확인하는 메소드
		 */


		carList.remove(0);

		// 해당 인덱스에 삽입되어있는 객체를 제거하는것이지
		// 순서 자체를 앞당기진 않는다.

		for (Car car : carList) { //향상 for 문
			System.out.println(car);
		}

		System.out.println(carList.contains(a)); // return 값은 boolean
		//size
		System.out.println(carList.size()); // return 값은 int
		System.out.println(carList.isEmpty()); // return 값은 boolean

	}

}





@ToString
 class Car {

	// 생성자 field(영역) (전체 변수에 대한 파라미터(parameter, argument)를 받는 생성자)
	public Car (String carType, String companyName) {
		this.carType = carType;
		this.companyName = companyName;
		this.wheelNumber = 4;
	}

	public Car () {
		this.wheelNumber = 4;
	}

	// 변수 field(영역)
	private String carType;
	private String companyName;
	private Integer wheelNumber;


	// 메소 field(영역)
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName){ //void 리턴값이 없는 메소드
		this.companyName = companyName;
	}




//
//    public void setWheelNumber(Integer number) {
//        this.wheelNumber = wheelNumber;
//    }
//


}