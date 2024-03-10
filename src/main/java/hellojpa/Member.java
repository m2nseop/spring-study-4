package hellojpa;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
//@Table(name = "USER") // 실제 디비의 테이블 이름이 USER 일 경우 매핑 // 따로 설정이 없으면 엔티티이름이 테이블 이름으로 매핑
public class Member {

    @Id
    private Long id;
//    @Column(name = "username") // 실제 디비의 테이블의 컬럼 이름이 "username"일 경우 매핑 // 따로 설정이 없으면 필드이름이 컬럼 이름으로 매핑
    private String name;

    public Member() { // JPA는 동적으로 객체를 생성해야하기 때문에 기본 생성자가 하나 있어야한다.
    }

    public Member(Long id, String name) {
        this.id = id;
        this.name = name;
    }

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
