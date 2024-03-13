package hellojpa;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.persistence.Transient;
import java.util.Date;

@Entity //(name="JPA가 내부적으로 구분하는 엔티티 이름")//보통 클래스인 기본값으로 씀
//@Table(name = "USER", catalog, schema, unique constraints) // 실제 디비의 테이블 이름이 USER 일 경우 매핑 // 따로 설정이 없으면 엔티티이름이 테이블 이름으로 매핑
public class Member {

    @Id
    private Long id;
//    @Column(name = "username") // 실제 디비의 테이블의 컬럼 이름이 "username"일 경우 매핑 // 따로 설정이 없으면 필드이름이 컬럼 이름으로 매핑
    @Column(name = "name")
    private String username;

    private Integer age;

    @Enumerated(EnumType.STRING) // enum 타입
    private RoleType roleType;

    @Temporal(TemporalType.TIMESTAMP)
    private Date createdDate;

    @Temporal(TemporalType.TIMESTAMP)
    private Date lastModifiedDate;

//    @Lob // varchar를 넘어서는 큰 데이터를 넣고 싶으면 @Lob을 써라 // clob dlob // 이미지, 동양싱 등등
//    private String description;

    @Transient // 데이터베이스에는 영향을 주지않는 임시 데이터로 쓰고 싶을 때
    private int temp;

    public Member() { // JPA는 동적으로 객체를 생성해야하기 때문에 기본 생성자가 하나 있어야한다.
    }

    public Member(Long id, String name) {
        this.id = id;
        this.username = name;
    }

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

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public RoleType getRoleType() {
        return roleType;
    }

    public void setRoleType(RoleType roleType) {
        this.roleType = roleType;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public Date getLastModifiedDate() {
        return lastModifiedDate;
    }

    public void setLastModifiedDate(Date lastModifiedDate) {
        this.lastModifiedDate = lastModifiedDate;
    }

    public int getTemp() {
        return temp;
    }

    public void setTemp(int temp) {
        this.temp = temp;
    }
}
