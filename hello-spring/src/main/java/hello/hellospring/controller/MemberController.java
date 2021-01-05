package hello.hellospring.controller;

import hello.hellospring.domain.Member;
import hello.hellospring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class MemberController {

    // private final MemberService memberService = new MemberService();
    private final MemberService memberService;

    @Autowired
    public MemberController(MemberService memberService) { //DI의 방법 중 '생성자 주입' : 생성자를 통해 MemberService가 주입 됨.
        this.memberService = memberService;
    }

    @GetMapping("/members/new")
    public String createForm() {
        return "members/createMemberForm";
    }

    @PostMapping("/members/new")
    public String create(MemberForm form) { //MemberForm을 재료로 사용
        Member member = new Member();
        member.setName(form.getName());

        memberService.join(member); //회원가입

        return "redirect:/"; //가입 후 홈 화면으로 리다이렉트
    }
}
