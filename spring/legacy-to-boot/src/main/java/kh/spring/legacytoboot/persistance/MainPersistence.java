package kh.spring.legacytoboot.persistance;

import org.hibernate.annotations.Persister;

import javax.persistence.*;

@PersistenceUnit
public class MainPersistence {
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("legacy-to-boot");
    EntityManager em = emf.createEntityManager();
    EntityTransaction tx = em.getTransaction();
}
