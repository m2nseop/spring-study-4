package hellojpa;

import jakarta.persistence.*;
import java.util.List;

public class JpaMain {

    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
        EntityManager em = emf.createEntityManager();

        EntityTransaction tx = em.getTransaction();
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
            List<Member> result = em.createQuery("select m from Member as m", Member.class)
//                    .setFirstResult(1) // 페이지네이션 가져올 첫번째 인덱스 // 주의) 인덱스는 0부터 시작이다.
//                    .setMaxResults(2) // 페이지니에션 가져오는 개수 // 1번 인덱스부터 2개 가져와
                    .getResultList();

            for (Member member : result) {
                System.out.println("member.name = " + member.getName());
            }

            tx.commit();
        } catch (Exception e) {
            // 문제가 생길경우 작업한 내용 롤백(초기화)
            tx.rollback();
        } finally {
            // 문제가 없을 경우 em을 close // em은 문제가 발생하더라도 반드시 close를 해주어야 한다.
            em.close();
        }

        emf.close();
    }
}
