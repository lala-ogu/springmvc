package practice.springmvc.domain;

public class Member {
    // 비즈니스 domain 객체로 관련 행위(메소드)를 가질 수 있습니다. 
    private Long id;
    // 시스템이 저장하는 id(db의 pk에 대응한다 봐도 무방)
    private String name;
    
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
}
