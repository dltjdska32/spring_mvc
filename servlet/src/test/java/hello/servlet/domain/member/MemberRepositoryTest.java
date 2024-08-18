package hello.servlet.domain.member;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class MemberRepositoryTest {

    MemberRepository memberRepository = MemberRepository.getInstance();

    // 각각의 테스트가 실행되난 후 무조건 실행.
    //각각의 테스트를 확인하기 위해 -> 각각의 테스트는 순서가 보장되지 않는다.
    // 멤버 레포에서 데이터를 지우지 않으면 테스트 통과가 안될수 있다.
    @AfterEach
    void afterEach(){
        memberRepository.clearStore();
    }

    @Test
    void save() {

        Member member = new Member("hello", 20);

        Member saved = memberRepository.save(member);

        Member findMember = memberRepository.findById(saved.getId());
        assertThat(findMember).isEqualTo(member);

    }


    @Test
    void findAll() {

        Member member = new Member("hello", 20);
        Member member2 = new Member("hello2", 22);

        memberRepository.save(member);
        memberRepository.save(member2);

        List<Member> result = memberRepository.findAll();

        //결과 길이가 2와 같아야 통과
        assertThat(result.size()).isEqualTo(2);
        //리스트에 멤버, 멤버2가 있는지 확인.
        assertThat(result).contains(member,member2);
    }

}