package hellojpa;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.persistence.Transient;
import java.util.Date;
import java.util.concurrent.locks.Lock;

@Entity //(name="JPA가 내부적으로 구분하는 엔티티 이름")//보통 클래스인 기본값으로 씀
//@Table(name = "USER", catalog, schema, unique constraints) // 실제 디비의 테이블 이름이 USER 일 경우 매핑 // 따로 설정이 없으면 엔티티이름이 테이블 이름으로 매핑
//@SequenceGenerator(
//        name = "MEMBER_SEQ_GENERATOR",
//        sequenceName = "MEMBER_SEQ",
//        initialValue = 1,
//        allocationSize = 50)
public class Member {

    @Id @GeneratedValue
    @Column(name = "MEMBER_ID")
    private Long id;

    @Column(name = "USERNAME") // 실제 디비의 테이블의 컬럼 이름이 "username"일 경우 매핑 // 따로 설정이 없으면 필드이름이 컬럼 이름으로 매핑
    private String username;

//    @Column(name = "TEAM_ID")
//    private Long teamId;

//    @ManyToOne // @현재(주인)엔티티To필드엔티티 , Member(Many) To Team(One), 하나의 팀에는 여러명의 멤버가 있을 수 있지만, 하나의 멤버는 하나의 팀에만 소속되어야 한다.
//    @JoinColumn(name = "TEAM_ID")
//    private Team team;

    @OneToOne
    @JoinColumn(name = "LOCKER_ID") // 외래키, 외래키가 존재하는 엔티티가 연관관계 주인
    private Locker locker;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

//    public Team getTeam() {
//        return team;
//    }
//
//    // 편의 메소드
//    // 양쪽 모두의 값을 세팅하는 하나의 메소드를 만들면 개발하다가 값의 세팅을 까먹어서 실수할 확률이 줄어든다.
//    public void setTeam(Team team) {
//        this.team = team;
//        team.getMembers().add(this);
//    }
}
