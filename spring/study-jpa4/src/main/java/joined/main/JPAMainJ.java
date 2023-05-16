package joined.main;


import joined.entity.MovieJ;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class JPAMainJ {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("studyJPA4");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        try {
            MovieJ movieJ = new MovieJ();
            movieJ.setDirector("A");
            movieJ.setActor("B");
            movieJ.setName("바람과 함께 사라지다.");
            movieJ.setPrice(10000);
            em.persist(movieJ);

            em.flush();
            em.clear();
            MovieJ findMovieJ = em.find(MovieJ.class, movieJ.getId());
            System.out.println("findMovie = " + findMovieJ.getName());

            tx.commit();
        } catch (Exception e) {
            tx.rollback();
        } finally {
            em.close();
        }
        emf.close();
    }
}
