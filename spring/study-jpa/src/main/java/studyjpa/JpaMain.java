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
        tx.begin();

        List<Member> result = em.createQuery("select m from Member as m", Member.class)
                .setFirstResult(0)
                .setMaxResults(10)
                .getResultList();
        result.forEach(e -> System.out.println("member.name = " + e.getName()));


        tx.commit();
        em.close();
        emf.close();
    }
}
