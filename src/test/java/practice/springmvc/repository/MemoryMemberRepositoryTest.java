package practice.springmvc.repository;

import static org.assertj.core.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import practice.springmvc.domain.Member;

public class MemoryMemberRepositoryTest {
 
    MemoryMemberRepository repository = new MemoryMemberRepository();
    // JUnit도 프레임워크이기 때문에 bean으로 관리됩니다.

    @AfterEach  // 일종의 콜백메소드로, 메소드가 끝난 뒤 실행됩니다.
    public void afterEach(){
        repository.clearStore();
    }

    @Test   // test 메소드를 위한 JUnit 어노테이션
    public void save() {
        // 테스트코드를 작성하는 것은 실제 코드와 비슷합니다.
        Member member= new Member();
        member.setName("spring");
        // 객체를 직접 생성해서 프로퍼티를 설정합니다.

        repository.save(member);
        Member result = repository.findById(member.getId()).get();
        // 실제 로직이 동작하듯이 저장하고 id값으로 객체를 불러옵니다.
        // Optional에서 가져오므로 마지막 .get메소드를 붙여 가져옵니다.

        //Assertions.assertEquals(member, result);
        // 검증을 위한 메소드로 jupiter에서 제공하는 assert입니다.
        // 기대하는 member가 result와 같은지 비교하는 메소드입니다.
        // 테스트를 실행해 참이면 녹색불이 나타납니다.

        assertThat(member).isEqualTo(result);
        // Assertions.assertThat(member).isEqualTo(null);
        // 실패하는 테스트 케이스. 실패하는 모든 경우도 테스트 해야합니다.
        // assertj에서 제공하는 좀더 편리한 메소드입니다.
        // static으로 import해서 바로 메소드를 사용가능합니다.
    }

    @Test
    public void findByName(){
        Member member1= new Member();
        member1.setName("spring1");
        repository.save(member1);
        
        Member member2= new Member();
        member2.setName("spring2");
        repository.save(member2);

        Member result = repository.findByName("spring1").get();

        assertThat(result).isEqualTo(member1);
        // "spring1"이라는 이름으로 result를 조회했으므로 member1과 같아야 합니다.
        // assertThat(result).isEqualTo(member2);
        // 실패하는 테스트
    }

    @Test
    public void findAll(){

        Member member1= new Member();
        member1.setName("spring1");
        repository.save(member1);
        
        Member member2= new Member();
        member2.setName("spring2");
        repository.save(member2);

        List<Member> result = repository.findAll();

        assertThat(result.size()).isEqualTo(2);
        // list의 크기를 비교합니다.
        // assertThat(result.size()).isEqualTo(1);
        // 실패하는 테스트
    }
}
