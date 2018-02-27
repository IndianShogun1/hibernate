import org.hibernate.Session;
import org.hibernate.SessionFactory;

import javax.security.auth.login.Configuration;
import java.sql.Date;
import java.util.List;

public class Application {

    public static void main(String[] args) {

        SessionFactory sessionFactory= new org.hibernate.cfg.
                Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();

//        Author author1 = new Author();
//        author1.setFirstName("fn2");
//        author1.setLastName("ln2");
//        author1.setAge(42);
//        author1.setDob(Date.valueOf("1982-07-12"));
//        session.save(author1);                                           //create

        Author author2 = session.get(Author.class, 1);      //read
//
//        System.out.println(author2);
//
        author2.setFirstName("UpdatedName");
        session.update(author2);                                //update

        Author author1 = session.get(Author.class, 1);
        session.delete(author1);
        session.getTransaction().commit();

        //System.out.println();

        session.close();
        sessionFactory.close();


    }
}
