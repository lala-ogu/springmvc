package practice.springmvc.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import practice.springmvc.domain.Member;
import practice.springmvc.repository.MemberRepository;

//@Service    // Controller어노테이션 처럼 bean으로 등록합니다.
public class MemberService {
    
    private final MemberRepository memberRepository;

    // DI받도록 변경합니다.
    @Autowired
    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    // 회원 가입 로직
    public Long join(Member member){
        validateSameName(member);   // 중복 검사. 중복값이 잇는 경우 예외를 던져 나갑니다.
        memberRepository.save(member);
        // 중복값이 없는 경우 저장합니다.
        return member.getId();
    }

    private void validateSameName(Member member) {
        //같은 이름 중복 x
        memberRepository.findByName(member.getName())
         .ifPresent(m -> { // 람다식. 값이 null이 아니면(ifPresent) 동작합니다. optional이여서 가능합니다.
                throw new IllegalStateException("이미 존재하는 회원입니다.");
        });
    }

    // 전체 회원 조회
    public List<Member> findAllMembers(){
        return memberRepository.findAll();
    }

    // 회원 조회
    public Optional<Member> findOne(Long memberId){
        return memberRepository.findById(memberId);
    }
}
