package hello.hellospring.repository;

import hello.hellospring.domain.Member;

import java.util.List;
import java.util.Optional;

public interface MemberRepository {
    Member save(Member member); //회원을 저장하면 저장된 회원이 반환됨. 회원이 저장소에 저장됨
    Optional<Member> findById(Long id); //id로 회원을 찾는 메소드
    Optional<Member> findByName(String name); //name으로 회원 찾는 메소드
    //optional : findbyid, findbyname 의 결과가 null일때 optional로 null을 감싸서 반환하게됨 (Java8의 신기능 - null의 처리)
    List<Member> findAll(); //지금까지 저장된 모든 회원들의 리스트를 반환함

}
