package hello.hellospring.service;

import hello.hellospring.domain.Member;
import hello.hellospring.repository.MemberRepository;
import hello.hellospring.repository.MemoryMemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MemberService { /** test 만드려면 cmd + Shift + T **/

private final MemberRepository memberRepository;

    @Autowired
    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }
//외부에서 memberRepository를 넣어주는 형태. => DI(Dependencies Injection) 의존성 주입

    /**
     * 회원 가입
     */
    public Long join(Member member) {

        validateDuplicateMember(member); //같은 이름이 있는 중복회원 X 처리. 중복회원검증
        memberRepository.save(member);
        return member.getId();

    }

    private void validateDuplicateMember(Member member) {
        memberRepository.findByName(member.getName())
                .ifPresent(m -> {
                    throw new IllegalStateException("이미 존재하는 회원입니다.");
                } );
        //Optional<Member> result = memberRepository.findByName(member.getName()); //이름을 가져와서 그 이름으로 리포지토리에서 조회함
//        result.ifPresent(m -> {
//            throw new IllegalStateException("이미 존재하는 회원입니다.");
//        }); //result에 null이 아니라 결과값이 있으면 throw해줌 => Optional 덕분에 ifPresent이라는 메소드 사용 가능
    }

    /**
     * 전체 회원 조회
     */
    public List<Member> findMembers() {
        return memberRepository.findAll();
    }

    /**
     * 회원id를 넘겨서 특정 회원 조회
     */
    public Optional<Member> findOne(Long memberId) {
        return memberRepository.findById(memberId);
    }



}