import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;


public class Ques4 {
    public static void main(String[] args) {
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();

        Author author1 = new Author();
        author1.setFirstName("fn1");
        author1.setLastName("ln1");
        author1.setAge(42);
        author1.setDob(Date.valueOf("1982-07-12"));
        Address address1 = new Address();
        address1.setLocation("Noida");
        address1.setState("Uttar Pradesh");
        address1.setStreetNumber("21");
        author1.setAddress(address1);
        List<String> subject1 = new ArrayList<>();
        subject1.add("Archaeology");
        subject1.add("Mathematics");
        subject1.add("Theology");
        author1.setSubjects(subject1);

        Author author2 = new Author();
        author2.setFirstName("fn2");
        author2.setLastName("ln2");
        author2.setAge(24);
        author2.setDob(Date.valueOf("1994-03-06"));
        Address address2 = new Address();
        address2.setLocation("Delhi");
        address2.setState("Delhi");
        address2.setStreetNumber("55");
        author2.setAddress(address2);
        List<String> subject2 = new ArrayList<>();
        subject2.add("Science Fiction");
        subject2.add("Fantasy");
        subject2.add("Mathematics");
        author2.setSubjects(subject2);

        List<Author> authors1 = new ArrayList<>();
        authors1.add(author1);
        authors1.add(author2);

        List<Book> books1 = new ArrayList<>();
        Book book1 = new Book();
        book1.setBookName("book1");
        book1.setAuthor(authors1);
        books1.add(book1);
        Book book2 = new Book();
        book2.setBookName("book2");
        book2.setAuthor(authors1);
        books1.add(book2);
        author1.setBook(books1);
        session.persist(author1);


        List<Book> books2 = new ArrayList<>();
        Book book3 = new Book();
        book3.setBookName("book3");
        book3.setAuthor(authors1);
        books2.add(book3);
        Book book4 = new Book();
        book4.setBookName("book4");
        book4.setAuthor(authors1);
        books2.add(book4);
        author2.setBook(books2);
        session.persist(author2);
//
//        Author author3 = new Author();
//        author3.setFirstName("fn3");
//        author3.setLastName("ln3");
//        author3.setAge(35);
//        author3.setDob(Date.valueOf("1990-12-12"));
//        Address address3 = new Address();
//        address3.setLocation("Jabalpur");
//        address3.setState("Madhya Pradesh");
//        address3.setStreetNumber("11");
//        author3.setAddress(address3);
//        List<String> subject3 = new ArrayList<>();
//        subject3.add("Physics");
//        subject3.add("mechanics");
//        subject3.add("Mathematics");
//        author3.setSubjects(subject3);
//        List<Book> books3 = new ArrayList<>();
//        Book book5 = new Book();
//        book5.setBookName("book5");
//        book5.setAuthor(author3);
//        books3.add(book5);
//        Book book6 = new Book();
//        book6.setBookName("book6");
//        book6.setAuthor(author3);
//        books3.add(book6);
//        author3.setBook(books3);
//        session.persist(author3);

//        Author author4 = new Author();
//        author4.setFirstName("fn4");
//        author4.setLastName("ln4");
//        author4.setAge(21);
//        author4.setDob(Date.valueOf("1996-07-15"));
//        session.save(author4);

        session.getTransaction().commit();
        session.close();
        sessionFactory.close();
    }
}
