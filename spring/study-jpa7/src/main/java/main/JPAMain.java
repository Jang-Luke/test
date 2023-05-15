package main;

import entity.Child;
import entity.Parent;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.stream.Collectors;

public class JPAMain {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("studyJPA7");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        try {
            Child child1 = new Child();
            Child child2 = new Child();
            Parent parent = new Parent();
            parent.addChild(child1);
            parent.addChild(child2);
            em.persist(parent);

            em.flush();
            em.clear();
            em.createQuery("")
                    .setParameter("a", "a")
                    .setParameter(1, "b");
            Parent findParent = em.find(Parent.class, parent.getId());
            findParent.getChildren().remove(0);

            tx.commit();
        } catch (Exception e) {
            tx.rollback();
        } finally{
            em.close();
        }
        emf.close();
    }
}
