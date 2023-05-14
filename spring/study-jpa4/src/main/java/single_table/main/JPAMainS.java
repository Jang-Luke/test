package single_table.main;


import single_table.entity.AlbumS;
import single_table.entity.BookS;
import single_table.entity.MovieS;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class JPAMainS {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("studyJPA4");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        try {
            MovieS movieS = new MovieS();
            movieS.setDirector("A");
            movieS.setActor("B");
            movieS.setName("바람과 함께 사라지다.");
            movieS.setPrice(10000);
            em.persist(movieS);
            BookS bookS = new BookS();
            bookS.setAuthor("Kafka");
            bookS.setIsbn("ISBN");
            bookS.setName("변신");
            bookS.setPrice(8600);
            em.persist(bookS);
            BookS bookS2 = new BookS();
            bookS2.setAuthor("J.K.Rolling");
            bookS2.setIsbn("ISBN");
            bookS2.setName("해리포터");
            bookS2.setPrice(11200);
            em.persist(bookS2);
            AlbumS albumS = new AlbumS();
            albumS.setArtist("Oasis");
            albumS.setName("Don't Look Back In Anger");
            albumS.setPrice(25000);
            em.persist(albumS);

            em.flush();
            em.clear();

            MovieS findMovie = em.find(MovieS.class, movieS.getId());
            AlbumS findAlbum = em.find(AlbumS.class, albumS.getId());
            BookS findBook = em.find(BookS.class, bookS2.getId());

            tx.commit();
        } catch (Exception e) {
            tx.rollback();
        } finally {
            em.close();
        }
        emf.close();
    }
}
