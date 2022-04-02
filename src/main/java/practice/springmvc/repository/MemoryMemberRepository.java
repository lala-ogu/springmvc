package practice.springmvc.repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import practice.springmvc.domain.Member;

public class MemoryMemberRepository implements MemberRepository {

    private static Map<Long, Member> store = new HashMap<>();
    // 공유되는 변수 이므로 ConcurrentHashMap을 사용해야하지만 예제이므로 사용합니다.
    private static long sequence = 0L;
    // 역시나 동시성 문제가 있지만 단순하게 넘어가겠습니다.

    @Override
    public Member save(Member member) {
        member.setId(++sequence);
        store.put(member.getId(), member);
        // memory 저장개념이기 때문에 정보를 map형태로 저장합니다.
        return member;
    }

    @Override
    public Optional<Member> findById(Long id) {
        return Optional.ofNullable(store.get(id));
        // null 값을 자동으로 감싸서 반환합니다.
    }

    @Override
    public Optional<Member> findByName(String name) {
        return store.values().stream() //람다식 루프
                .filter(member -> member.getName().equals(name))    // 필터링
                .findAny(); // name과 일치하는 값을 "하나라도" 찾으면 반환
                // null일 경우 optional로 감싸져서 반환합니다.
    }

    @Override
    public List<Member> findAll() {
        return new ArrayList<>(store.values());
        // loop를 돌리기 쉬워 list를 많이 사용합니다.
    }
    
    public void clearStore(){
        store.clear();
    }
}
