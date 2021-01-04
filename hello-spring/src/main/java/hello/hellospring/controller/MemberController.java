package hello.hellospring.controller;

import hello.hellospring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class MemberController {

    // private final MemberService memberService = new MemberService();
    /**
     *  스프링이 관리하게 되면 스프링 컨테이너에 등록되고 컨테이너에서 받아서 쓰는 형태임.
     *  new MemberService()로 객체를 만들면 MemberController말고 다른 컨트롤러들이 MemberService를 갖다 쓸 수 있게 됨 (ex. 주문 컨트롤러에서도 멤버서비스 갖다 쓰고)
     *  사실, MemberService 인스턴스를 여러 개 만들어 쓸 필요가 없는 구조인데도 불구하고. 즉 위의 코드는 메모리낭비임.
     *  관련된 애들(MemberController - MemberService - MemberRepository)을 하나의 인스턴스 안에 묶어 사용하면 메모리를 절약할 수 있다.
     *  그 방법 중 하나가 '컴포넌트 스캔과 자동 의존관계 설정'
     */

    private final MemberService memberService;

    /**
     * MemberController가 스프링 컨테이너에 등록되면서 생성자를 호출하게 됨
     * Autowired가 붙으면 스프링 컨테이너에 있는 MemberService를 가져와 MemberController에 딱 붙여주게 됨.
     */
    @Autowired
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }
}
