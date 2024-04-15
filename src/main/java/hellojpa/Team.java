package hellojpa;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Team extends BaseEntity {

    @Id @GeneratedValue
    @Column(name = "TEAM_ID")
    private Long id;
    private String name;

//    // 아래 코드가 없으면 Member와 Team의 다(M)대일(T) 단방향 연관관계, 있으면 다(M)대일(T) 양방향 연관관계
//    @OneToMany(mappedBy = "team") // 연결된 엔티티(Member)의 필드 명(team) // 얘는 그냥 읽기전용이어서 jpa에서 신경을 안쓴다.
//    private List<Member> members = new ArrayList<>();

    @OneToMany
    @JoinColumn(name = "TEAM_ID")
    private List<Member> members = new ArrayList<>();

    // 편의 메소드는 연관관계 둘 중 하나에만 존재해야한다.
    // 무한 루프가 걸리거나 꼬일 수 있기 때문이다.
    // 참고로 편의 메소드는 1대N 연관관계에서 1이든 N이든 위치는 상관없으며, 상황에 맞게 결정하면 된다.
//    public void addMember(Member member) {
//        member.setTeam(this);
//        members.add(member);
//    }

    public List<Member> getMembers() {
        return members;
    }

    public void setMembers(List<Member> members) {
        this.members = members;
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
