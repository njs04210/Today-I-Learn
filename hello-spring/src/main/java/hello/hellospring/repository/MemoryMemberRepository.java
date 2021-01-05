package hello.hellospring.repository;

import hello.hellospring.domain.Member;
import org.springframework.stereotype.Repository;

import java.util.*;

//메모리 구현체

public class MemoryMemberRepository implements MemberRepository{

    private static Map<Long, Member> store = new HashMap<>(); //save할때의 저장소. 메모리니까 필요. key는 회원id, value는 Member.
    private static long sequence = 0L;

    @Override
    public Member save(Member member) {
        member.setId(++sequence); //알아서 save될때 setId를 통해 id가 지정됨
        store.put(member.getId(), member); //key = member.getId(), value = member
        return member;
    }

    @Override
    public Optional<Member> findById(Long id) {
        return Optional.ofNullable(store.get(id)); //특정 id에 해당하는 value값, 즉 member 불러옴
    }

    @Override
    public Optional<Member> findByName(String name) {
        return store.values().stream()
                .filter(member -> member.getName().equals(name))
                .findAny();
    }

    //ArrayList 생성하면서 동시에 store.values()값 전달
    @Override
    public List<Member> findAll() {
        return new ArrayList<>(store.values());
    }

    public void clearStore() {
        store.clear();
    }

}
