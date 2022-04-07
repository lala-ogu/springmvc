package practice.springmvc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import practice.springmvc.domain.Member;

import java.util.Optional;

// Entity객체와 pk의 타입을 제너릭으로 선언합니다, 다중상속으로 MemberRepository를 상속받아 오버라이드 합니다.
public interface SpringDataJpaMemberRepository extends JpaRepository<Member, Long>, MemberRepository {

    @Override
    Optional<Member> findByName(String name);
    // 데이터 Jpa는 메소드만으로 query를 실행합니다.
}
