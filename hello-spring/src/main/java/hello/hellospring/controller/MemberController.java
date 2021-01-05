package hello.hellospring.controller;

import hello.hellospring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class MemberController {

    // private final MemberService memberService = new MemberService();
    private final MemberService memberService;

    @Autowired
    public MemberController(MemberService memberService) { //DI의 방법 중 '생성자 주입' : 생성자를 통해 MemberService가 주입 됨.
        this.memberService = memberService;
    }
}
