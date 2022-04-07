package practice.springmvc.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;
import practice.springmvc.domain.Member;

public interface MemberRepository {
    // 구체적인 클래스 명시를 피하기 위해 인터페이스로 선언합니다.
    Member save(Member member); //회원 저장기능
    Optional<Member> findById(Long id); // id를 이용하여 조회
    Optional<Member> findByName(String name);   // name을 이용하여 조회
    // Optional : java8에서 추가된 기능으로 null값을 감싸서 return합니다.
    List<Member> findAll(); //모두 조회
    void clearStore();
    
}
