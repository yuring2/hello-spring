package hello.hellospring.repository;

import hello.hellospring.domain.Member;

import java.util.*;

public class MemoryMemberRepository implements MemberRepository {

    private static Map<Long, Member> store = new HashMap<>();  // hashmap도 클래스니까 Static을 붙여주면 그냥 가져다 쓸 수 있음
    private static long sequence = 0L; // 0,1,2 이렇게 키 값을 생성해주는 역할



    @Override
    public Member save(Member member) {
        member.setId(++sequence); // store에 저장하기 전에 아이디 값을 세팅하고
        store.put(member.getId(), member);
        return member;
    }

    @Override
    public Optional<Member> findByid(Long id) {
          return Optional.ofNullable(store.get(id)); // NULL로 반환될 확률이 있으며 이렇게 감싸준다.
    }

    @Override
    public Optional<Member> findByname(String name) {

         return store.values().stream().filter(member -> member.getName().equals(name)).findAny();
                  // store에 저장되어있는 이름 매개변수로 넘어온 이름이 같은 경우에 반환
                  // findany는 fiter로 찾은 결과중 아무값이나 하나 선택하라는 의미

    }

    @Override
    public List<Member> findAll() {
           return new ArrayList<>(store.values());
    }

    public void claerStore()
    {
        store.clear();
    }
}
