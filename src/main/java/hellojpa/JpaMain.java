package hellojpa;

import jakarta.persistence.*;

public class JpaMain {

    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
        EntityManager em = emf.createEntityManager();

        EntityTransaction tx = em.getTransaction();
        tx.begin();

        try {
            // 오류가 발생할 경우를 대비하여 try catch를 사용

            // 회원 등록
//            Member member = new Member();
//            member.setId(1L);
//            member.setName("HelloA");

//            em.persist(member);

            // 회원 조회
            Member findMember = em.find(Member.class, 1L);
            System.out.println("findMember.id = " + findMember.getId());
            System.out.println("findMember.name = " + findMember.getName());


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
