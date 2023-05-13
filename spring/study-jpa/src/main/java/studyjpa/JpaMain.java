package studyjpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.List;

public class JpaMain {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");

        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();

        try {
            tx.begin();

            Member member1 = new Member(170L, "C");
            Member member2 = new Member(180L, "D");
            Member member3 = new Member(190L, "E");

            em.persist(member1);
            em.persist(member2);
            em.persist(member3);
            System.out.println("==-=-=-=-=-==-=-");

            tx.commit();
        } catch (Exception e) {
            tx.rollback();
        } finally {
            em.close();
        }
        emf.close();
    }
}
