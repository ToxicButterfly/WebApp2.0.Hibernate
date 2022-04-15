package app.model;

import app.entities.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import javax.persistence.Query;
import java.util.List;
import java.util.Optional;

public class UserDao implements Dao {
    @Override
    public void save(Object t) {
        Configuration con = new Configuration().configure().addAnnotatedClass(User.class);
        SessionFactory sf = con.buildSessionFactory();
        Session ses = sf.openSession();
        Transaction tx = ses.beginTransaction();
        ses.save(t);
        tx.commit();
        ses.close();
    }

    @Override
    public Optional find(int id) {
        Configuration con = new Configuration().configure().addAnnotatedClass(User.class);
        SessionFactory sf = con.buildSessionFactory();
        Session ses = sf.openSession();
        User user = ses.get(User.class, id);
        ses.close();
        return Optional.of(user);
    }

    @Override
    public List<User> findAll() {
        Configuration con = new Configuration().configure().addAnnotatedClass(User.class);
        SessionFactory sf = con.buildSessionFactory();
        Session ses = sf.openSession();
        Query query = ses.createQuery("SELECT a FROM User a", User.class);
        return query.getResultList();
    }

    @Override
    public void delete(int delId) {
        Configuration con = new Configuration().configure().addAnnotatedClass(User.class);
        SessionFactory sf = con.buildSessionFactory();
        Session ses = sf.openSession();
        Transaction tx = ses.beginTransaction();
        Query theQuery = ses.createQuery("delete from User where id=:userID");
        theQuery.setParameter("userID", delId);
        theQuery.executeUpdate();
        tx.commit();
        ses.close();
    }


}

