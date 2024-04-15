package hellojpa;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.List;
import javax.lang.model.SourceVersion;

public class JpaMain {

    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence
                .createEntityManagerFactory("hello");
        // 파라미터의 "hello"는 persistence.xml에 있는 <persistence-unit name="hello">의 "hello"와 같다.
        // 따라서 EntityManagerFactory가 persistence.xml에 있는 정보를 읽어오고 jpa(hibernate)를 사용할 수 있는 것이다. // + 데이터베이스와의 연동

        EntityManager em = emf.createEntityManager();
        // JPA는 작업을 해야할 경우( ex. 고객의 요청이 들어왔을 때 ) EntityManager를 통해서 작업을 해야한다.

        EntityTransaction tx = em.getTransaction();
        // JPA의 모든 작업은 Transaction 안에서 이루어져야한다.
        // 단순 조회 같은 경우는 Transaction 안에서 이루어지지 않아도 상관은 없다.

        tx.begin();

        try {
            // 오류가 발생할 경우를 대비하여 try catch를 사용

            // 회원 등록
//            Member member3 = new Member();
//            member3.setId(4L);
//            member3.setName("Hello4");
//            em.persist(member3);

            // 회원 조회
//            Member findMember = em.find(Member.class, 1L);
//            System.out.println("findMember.id = " + findMember.getId());
//            System.out.println("findMember.name = " + findMember.getName());

            // 회원 삭제
//            Member findMember = em.find(Member.class, 1L);
//            em.remove(findMember);

            // 회원 수정
//            Member findMember = em.find(Member.class, 1L);
//            findMember.setName("HelloJPA");

            // JPQL을 이용한 회원 조회
//            List<Member> result = em.createQuery("select m from Member as m", Member.class)
////                    .setFirstResult(1) // 페이지네이션 가져올 첫번째 인덱스 // 주의) 인덱스는 0부터 시작이다.
////                    .setMaxResults(2) // 페이지니에션 가져오는 개수 // 1번 인덱스부터 2개 가져와
//                    .getResultList();
//
//            for (Member member : result) {
//                System.out.println("member.name = " + member.getName());
//            }

            // 비영속
//            Member member = new Member();
//            member.setId(101L);
//            member.setName("HelloJPA");

            // 영속
//            System.out.println("=== Before ===");
//            em.persist(member);
//            System.out.println("=== After ===");
            // Before와 After사이에 쿼리가 날라갈 것 같지만 그렇지 않다. // tx.commit() 시점에 쿼리가 날라간다.

//            Member findMember1 = em.find(Member.class, 101L); // 어플리케이션을 다시 시작했을 경우 디비에는 존재하지만 1차캐쉬에 존재하지 않기 때문에 쿼리가 실행된다.
//            Member findMember2 = em.find(Member.class, 101L); // 위 코드에서 조회를 하는 과정에서 1차 캐쉬에 엔티티를 저장했기 때문에 쿼리가 실행되지 않는다.


            // 트랜잭션을 지원하는 쓰기 지원
//            Member member1 = new Member(150L, "A");
//            Member member2 = new Member(160L, "B");
//            em.persist(member1);
//            em.persist(member2);
//
//            System.out.println("============"); // 쓰기 지연 때문에 트랜잭션이 커밋되지 않은 이 시점 이후에 쿼리가 실행될 것

            // 변경 감지(Dirty Checking)
//            Member member1 = new Member(150L, "A"); // 했다고 가정
//            Member member = em.find(Member.class, 150L);
//            member.setName("ABC");

//            Member member = new Member();
//            member.setId(3L);
//            member.setUsername("C");
//            member.setRoleType(RoleType.ADMIN);

            // 기본 키 매핑 예제
//            Member member = new Member();
//            member.setUsername("C");
//
//            System.out.println("==========");
//            em.persist(member);
//            System.out.println("member.id = " + member.getId());
//            System.out.println("==========");

//            Member member1 = new Member();
//            member1.setUsername("A");
//
//            Member member2 = new Member();
//            member2.setUsername("B");
//
//            Member member3 = new Member();
//            member3.setUsername("C");
//
//            System.out.println("==========");
//
//            em.persist(member1);
//            em.persist(member2);
//            em.persist(member3);
//
//            System.out.println("member1.id = " + member1.getId());
//            System.out.println("member2.id = " + member2.getId());
//            System.out.println("member3.id = " + member3.getId());
//
//            System.out.println("==========");

//            Team team = new Team();
//            team.setName("TeamA");
//            em.persist(team);
//
//            Member member = new Member();
//            member.setUsername("member1");
//            member.setTeam(team);
//            em.persist(member);
//
//            team.getMembers().add(member);
//
//            em.flush(); // 위의 쿼리들을 날려주고
//            em.clear(); // 영속성 컨텍스트를 한번 비워준다.
//
//            Team findTeam = em.find(Team.class, team.getId());
//            List<Member> members = findTeam.getMembers();
//
//            System.out.println("============");
//            for (Member m : members) {
//                System.out.println("m.getUsername() = " + m.getUsername());
//            }
//            System.out.println("============");

//            Member member = new Member();
//            member.setUsername("member1");
//
//            em.persist(member);
//
//            Team team = new Team();
//            team.setName("TeamA");
//            team.getMembers().add(member);

//            em.persist(team);

//            Movie movie = new Movie();
//            movie.setDirector("aaaa");
//            movie.setActor("bbbb");
//            movie.setName("바람과함계사라지다.");
//            movie.setPrice(10000);
//            em.persist(movie);
//
//            em.flush();
//            em.clear();
//
//            Movie findMovie = em.find(Movie.class, movie.getId()); // 생성된 쿼리를 보면 ㅓoin을 해서 가져오는 것을 알 수 있다.
//            System.out.println("findMovie = " + findMovie);

//            Member member = new Member();
//            member.setUsername("user1");
//            member.setCreatedBy("kim");
//            member.setCreatedDate(LocalDateTime.now());
//
//            em.persist(member);

//            em.flush();
//            em.clear();

            Member member = new Member();
            member.setUsername("member1");

            em.persist(member);

            em.flush();
            em.clear();

//            // find
////            Member findMember = em.find(Member.class, member.getId()); // select 쿼리가 나간다.
//
//            // getReference
//            Member findMember = em.getReference(Member.class, member.getId()); // select 쿼리가 나가지 않는다.
//            System.out.println("findMember.id = " + findMember.getId()); // 이때도 select 쿼리가 나가지 않는다. // member.getId()로 부터 이미 member의 id를 알고 있기 때문에 디비에 접근할 필요가 없기 때문이다.
//            System.out.println("findMember.username = " + findMember.getUsername()); // 이때부터는 디비에 접근해야만 알 수 있는 정보이기 때문에 이제서야 쿼리가 날라간다.
//            System.out.println("findMember.username = " + findMember.getUsername()); // 이때부터는 디비에 접근해야만 알 수 있는 정보이기 때문에 이제서야 쿼리가 날라간다.

            Member m1 = em.find(Member.class, member.getId());
            System.out.println("m1 = " + m1.getClass());

            Member reference = em.getReference(Member.class, member.getId());
            System.out.println("reference = " + reference.getClass());

            System.out.println(m1.getClass() == reference.getClass());

            tx.commit();
            // commit을 해야 변경사항이 db에 반영이 된다.
        } catch (Exception e) {
            // 문제가 생길경우 작업한 내용 롤백(초기화)
            tx.rollback();
        } finally {
            // 자원을 다 썼거나, 문제가 없을 경우 em을 close // em은 문제가 발생하더라도 반드시 close를 해주어야 한다. // 그래야 데이터베이스의 connection이 반환된다.
            em.close();
        }
        // 웹앱의 WAS를 사용한다고 했을 때 WAS가 내려가는 경우 EntityManagerFactory도 닫아줘야 resource pool들도 내려간다.
        emf.close();
    }
}
