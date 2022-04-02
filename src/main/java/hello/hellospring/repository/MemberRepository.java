package hello.hellospring.repository;

import hello.hellospring.domain.Member;

import java.util.List;
import java.util.Optional;

public interface MemberRepository {

    //4가지 기능
    Member save(Member member);  // 회원을저장하는 기능
    Optional<Member> findByid(Long id); // 아이디로 회원을 찾는 기능
    Optional<Member> findByname(String naem);
    List<Member> findAll(); // 저장된 모든 회원을 반환해줌

}
