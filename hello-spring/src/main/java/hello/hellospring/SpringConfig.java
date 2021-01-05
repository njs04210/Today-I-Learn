package hello.hellospring;

import hello.hellospring.repository.MemberRepository;
import hello.hellospring.repository.MemoryMemberRepository;
import hello.hellospring.service.MemberService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 스프링에서 @Configuration 애노테이션 읽은 뒤, "이건 스프링 빈에 등록하라는거네" 하고 인식해서
 * @Bean이 붙은 메소드 MemberService, MemberRepository의 로직을 호출해서 스프링빈에 등록한다.
 * 결론: 스프링이 뜨면서 Memservice와 MemberRepository가 둘 다 스프링빈에 등록되고,
 * 스프링빈에 등록되어있는 MemberRepository를 MemberService에 넣어줌. (@Controller는 건들지말기!)
 */

@Configuration
public class SpringConfig {

    @Bean
    public MemberService memberService() {
        return new MemberService(memberRepository());
    }

    @Bean
    public MemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }
}
