package repository.MemoryMemberRepositoty;

import hello.hellospring.domain.Member;
import hello.hellospring.repository.MemberRepository;
import hello.hellospring.repository.MemoryMemberRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Optional;

public class test {

    MemoryMemberRepository repository = new MemoryMemberRepository();

    // 테스트는 서로 의존관게 없이 설계가 되어야 한다. 그래서 이렇게...
    @AfterEach
    public void afterEach()  // 하나의 메서드를 테스트하고 List에 저장 돼 있는 객체 초기화
    {
        repository.claerStore();
    }

    @Test
    public void save()
    {
        Member member = new Member();
        member.setName("최유리");

        repository.save(member);
        Member result =  repository.findByid(member.getId()).get();  //optional에서 까서 꺼내주려면 .get
        Assertions.assertThat(member).isEqualTo(result); // 검증
    }

    @Test
    public void findByname()
    {
        Member member1 = new Member();
        member1.setName("김희진");
        Member member2 = new Member();
        member2.setName("김수지");

        repository.save(member1);
        repository.save(member2);

           Member result = repository.findByname("김희진").get();
           Assertions.assertThat(result).isEqualTo(member1);
    }


    @Test
    public void findAll() {
        Member member1 = new Member();
        member1.setName("김희진");
        repository.save(member1);

        Member member2 = new Member();
        member2.setName("김수지");
        repository.save(member2);

        List<Member> result = repository.findAll();
        Assertions.assertThat(result.size()).isEqualTo(2);


    }



}


