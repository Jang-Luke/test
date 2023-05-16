package table_per_class.main;


import table_per_class.entity.AlbumT;
import table_per_class.entity.BookT;
import table_per_class.entity.ItemT;
import table_per_class.entity.MovieT;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class JPAMainT {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("studyJPA4");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        try {
            MovieT movieT = new MovieT();
            movieT.setDirector("A");
            movieT.setActor("B");
            movieT.setName("바람과 함께 사라지다.");
            movieT.setPrice(10000);
            em.persist(movieT);
            BookT bookT = new BookT();
            bookT.setAuthor("Kafka");
            bookT.setIsbn("ISBN");
            bookT.setName("변신");
            bookT.setPrice(8600);
            em.persist(bookT);
            BookT bookT2 = new BookT();
            bookT2.setAuthor("J.K.Rolling");
            bookT2.setIsbn("ISBN");
            bookT2.setName("해리포터");
            bookT2.setPrice(11200);
            em.persist(bookT2);
            AlbumT albumT = new AlbumT();
            albumT.setArtist("Oasis");
            albumT.setName("Don't Look Back In Anger");
            albumT.setPrice(25000);
            em.persist(albumT);

            em.flush();
            em.clear();

            ItemT findMovie = em.find(ItemT.class, movieT.getId());
            ItemT findAlbum = em.find(ItemT.class, albumT.getId());
            ItemT findBook = em.find(ItemT.class, bookT2.getId());

            tx.commit();
        } catch (Exception e) {
            tx.rollback();
        } finally {
            em.close();
        }
        emf.close();
    }
}
