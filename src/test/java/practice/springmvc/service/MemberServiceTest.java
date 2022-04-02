package practice.springmvc.service;

import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import practice.springmvc.domain.Member;
import practice.springmvc.repository.MemberRepository;
import practice.springmvc.repository.MemoryMemberRepository;

import static org.assertj.core.api.Assertions.*;

public class MemberServiceTest {

    MemberService memberService;

    // MemoryMemberRepository memberRepository = new MemoryMemberRepository();
    // 후처리를 위해 가져온 객체이지만 이미 memberService의 프로퍼티로 같은 객체가 다른 인스턴스로 존재합니다.
    // 물론 repository에서 static으로 선언되어 서로 다른 객체가 값을 간섭하진 않지만 거슬리게 됩니다.
    
    MemberRepository memberRepository;

    @BeforeEach
    public void BeforeEach(){
        // DI
        memberRepository = new MemoryMemberRepository();
        memberService = new MemberService(memberRepository);
    }

    @AfterEach
    public void afterEach(){
        memberRepository.clearStore();
    }

    @Test
    void testFindAllMembers() {

    }

    @Test
    void testFindOne() {

    }

    @Test
    void 회원가입() {
        // given
        Member member = new Member();
        member.setName("spring");

        // when
        Long saveId = memberService.join(member);

        // then
        Member findMember = memberService.findOne(saveId).get();
        assertThat(member.getName()).isEqualTo(findMember.getName());
        // 중요한 로직인 중복회원 검사가 빠졌으므로 반쪽자리 테스트입니다.
        
    }

    @Test
    void 중복회원예외(){
        // given
        Member member1 = new Member();
        member1.setName("spring");

        Member member2 = new Member();
        member2.setName("spring");

        // when

        memberService.join(member1);

    /*
        try {
            memberService.join(member2);
            fail(); // 테스트 실패
        } catch (IllegalAccessException e) {
            assertThat(e.getMessage()).isEqualTo("이미 존재하는 회원입니다.");
            // 테스트 성공
        }
    */

        // 위의 try/catch를 좀 더 간결하게 제공하는 assertThrows 메소드.
        // 해당하는 클래스가 발생해야하고, 
        assertThrows(IllegalStateException.class, () -> memberService.join(member2));
        // 메세지 검증
        IllegalStateException e =  assertThrows(IllegalStateException.class, () -> memberService.join(member2));
        assertThat(e.getMessage()).isEqualTo("이미 존재하는 회원입니다.");
    }
}
