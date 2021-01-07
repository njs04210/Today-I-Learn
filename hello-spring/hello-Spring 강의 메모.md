# hello-Spring 강의 메모
👀 커밋한 강의 코드에서의 메모들

1. 컴포넌트 스캔과 자동 의존관계 설정

	* DI(의존성 주입 = 객체 의존관계를 외부에서 넣어주는 것)의 방식 중 하나이다.
	* 생성자에  `@Autowired` 가 있으면 스프링이 연관된 객체를 스프링 컨테이너에서 찾아서 넣어준다.
	* commit명 **DI(의존성주입)** 은 개발자가 직접 주입한 방식이다.
	* 스프링이 올라올 때, `@Component`와 관련한 애노테이션(`@Service`, `@Repository`, `@Controleer`)이 존재할 경우, 스프링이 애노테이션이 붙은 클래스의 객체를 하나씩 생성하여 스프링 컨테이너에 등록한다. 그런 뒤, `@Autowired`를 통해 이 객체들을 연결한다.
		* MemberController는 MemberService를 쓸 수 있게, MemberService는 MemberRepository를 쓸 수 있게 된다.
	* 스프링은 스프링 컨테이너에 스프링 빈을 등록할 때, 기본적으로 **싱글톤(Singletone)** 으로 등록한다. 즉, 하나의 같은 인스턴스에 MemberController, MemberService, MemberRepository가 하나씩 존재한다. -> 같은 스프링 빈이면 모두 같은 인스턴스
	* 싱글톤이 아니게 설정할 수 있으나, 일반적으로 대부분 싱글톤 사용.
	
2. 자바 코드로 직접 스프링 빈 등록하기

	* 상황에 따라 구현 클래스를 변경해야 하면 설정을 통해 스프링 빈으로 등록한다.
		* 여기서는 구현체 MemoryMemberRepository 를 나중에 DB를 정한 뒤 DB와 연결해 사용하는 DBMemberRepository 를 사용할 예정인데, 그 때 다른 코드의 변경 없이 쉽게 바꿔낄 수 있다
	* DI의 3가지 방법에는 `필드주입` , `setter 주입`,  `생성자 주입`이 있는데, 의존관계가 실행중에 동적으로 변하는 경우는 거의 없으므로 ~~(아예 없다고 보면 됨)~~ **생성자 주입** 을 권장한다.

3. 회원 웹 기능 - 조회

	* 스프링 MVC의 **JavaBean(자바빈) 프로퍼티 규약** 이용
		* 객체의 데이터는 private으로 보호하고, 대신에 외부에서 접근할 때는 public으로 공개된 getter, setter 메소드를 통해서 접근한다.
			* `Member.java` 16-17라인 : getter&setter를 이용해 알아서 getId, getName 메소드를 실행해 값을 가져옴
			
4. 순수 JDBC

	* `SpringConfig.java` <br><br><img width="494" alt="스크린샷 2021-01-06 오후 11 26 24" src="https://user-images.githubusercontent.com/68816492/103779210-c49e3e00-5076-11eb-8766-0ca5707a92b8.png">
		* 스프링 프레임워크를 사용하는 이유와 객체지향의 다형성을 확인할 수 있는 코드.
		* MemberRepository 인터페이스의 구현체로
			* DB 지정 전 - 메모리를 이용해 데이터를 저장하는 MemoryMemberRepository 사용했으나,
			* DB 지정 후 - H2 Database와 JDBC를 이용해 데이터를 저장하는 JdbcMemberRepository 로 바꾸어 설정하였다.
		* 스프링 덕에 기존의 실제 어플리케이션과 관련된 코드는 하나도 손대지 않고, 오직 `SpringConfig.java` (애플리케이션을 설정, 조립하는 코드)만 수정하여 JdbcMemberRepository로 바꿔 사용할 수 있었다.
			* 스프링 없었다면 MemberService와 MemberRepository 인터페이스의 **의존 관계** 때문에, 구현체를 다른 걸로 바꾸기 위해서는 MemberService까지 코드 변경을 해야함. ~~MemberRepository에 의존하는 Service가 Member말고 더있다면..? 엄청난 코드 수정 필요~~
			* 스프링이 제공하는 스프링 컨테이너와 DI(의존성 주입)로 편리한 부품 변경이 가능하다.	
		* **SOLID** 중 `개방-폐쇄 원칙(OCP, Open-Closed Principle)` : 확장에는 열려있고, 수정(변경)에는 닫혀있다의 의미를 확인할 수 있는 대목
			* 즉,애플리케이션의 기능 추가(=확장)에는 열려있으나, 수정에는 닫혀있다는 것.
			* 객체지향에서의 다형성 개념을 잘 활용하면 기능을 추가하고 변경하는 등의 확장이 있어도 애플리케이션 전체를 수정할 필요가 없다. 물론 조립하는 코드(ex. SpringConfig.java) 는 수정해야하나, 실제 애플리케이션의 동작에 필요한 코드는 하나도 변경하지 않는 선에서 진행할 수 있다는 장점이 있다.
			
5. 스프링 통합 테스트

	* `@SpringBootTest` : 스프링 컨테이너와 테스트를 함께 실행
	* `@Transactional` : 테스트 케이스에 이 애노테이션이 있으면, 테스트 시작 전에 트랜잭션을 시작하고 테스트 완료 후에 항상 **롤백** 한다. 이렇게 하면 DB에 데이터가 남지 않으므로 다음 테스트에 영향을 주지 않는다.
		* 각각의 테스트 후 `@AfterEach` 를 이용해 데이터를 지우는 코드 없이 다음 테스트를 반복적으로 진행할 수 있다는 장점

