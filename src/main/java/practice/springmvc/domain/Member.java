package practice.springmvc.domain;

import javax.persistence.*;

@Entity
public class Member {

    @Id // 이 필드를 pk로 설정합니다.
    @GeneratedValue(strategy = GenerationType.IDENTITY) // id값을 자동 설정합니다.
    private Long id;

    // @Column(name = "username") 컬럼명 username과 대응하도록 합니다.
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
