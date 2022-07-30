package jpabook.start;

import javax.persistence.*;
import java.util.List;

/**
 * @author holyeye
 */
public class JpaMain {

    public static void main(String[] args) {

        //엔티티 매니저 팩토리 생성
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpabook");
        EntityManager em = emf.createEntityManager(); //엔티티 매니저 생성

        EntityTransaction tx = em.getTransaction(); //트랜잭션 기능 획득

        try {
            tx.begin(); //트랜잭션 시작
            logic(em);  //비즈니스 로직
            tx.commit();//트랜잭션 커밋

        } catch (Exception e) {
            e.printStackTrace();
            tx.rollback(); //트랜잭션 롤백
        } finally {
            em.close(); //엔티티 매니저 종료
        }

        emf.close(); //엔티티 매니저 팩토리 종료
    }

    public static void logic(EntityManager em) {

        Member member1 = new Member();
        member1.setUsername("지한");
        member1.setAge(20);
        //등록
        em.persist(member1);
        Member member2 = new Member();
        member2.setUsername("지한");
        member2.setAge(20);
        //등록
        em.persist(member2);
        Member member3 = new Member();
        member3.setUsername("지한");
        member3.setAge(20);
        //등록
        em.persist(member3);

//        Member findMember = em.find(Member.class, "0");
//        findMember.setUsername("영한");
//        
//        //수정
//        member.setAge(20);
//
//        //한 건 조회
//        Member findMember = em.find(Member.class, id);
//        System.out.println("findMember=" + findMember.getUsername() + ", age=" + findMember.getAge());
//
//        //목록 조회
//        List<Member> members = em.createQuery("select m from Member m", Member.class).getResultList();
//        
//        for(Member member:members) {
//        	System.out.println(member.getUsername());
//        }
//
//        //삭제
//        em.remove(findMember);

    }
}
