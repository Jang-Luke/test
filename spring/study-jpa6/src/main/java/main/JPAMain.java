package main;

import entity.Book;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.time.LocalDateTime;

public class JPAMain {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("studyJPA6");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        try {
            Book book = new Book();
            book.setName("JPA");
            book.setAuthor("김영한");
            book.setPrice(15000);
            book.setStockQuantity(23);
            book.setIsbn("1");
            book.setCreatedBy("admin1");
            book.setCreatedDate(LocalDateTime.now().minusDays(2).minusHours(4));
            book.setLastModifiedBy("admin3");
            book.setLastModifiedDate(LocalDateTime.now());
            em.persist(book);
            tx.commit();
        } catch (Exception e) {
            tx.rollback();
        } finally{
            em.close();
        }
        emf.close();
    }
}
