package web.dao;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import web.model.User;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class UserDaoImpl implements UserDao {

    @Autowired
    SessionFactory sessionFactory;

    @Override
    public void userAdd(User user) {
        Session session = sessionFactory.openSession();
        session.save(user);
        session.close();
    }

    @Override
    public void deleteUserById(Long id) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        Query q = session.createQuery("delete User where id = :id");
        q.setParameter("id", id);
        int i = q.executeUpdate();
        transaction.commit();
        session.close();
    }

    public void deleteUser(User user) {
        Session session = sessionFactory.openSession();
        session.delete(user);
    }

    @Override
    public User getUserById(Long id) {
        String hql = "from User where id = :id";
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        Query q = session.createQuery(hql);
        q.setParameter("id", id);
        List<User> list = q.list();
        return list.get(0);
    }


    @Override
    public User getUserByName(String name) {
        return null;
    }

    @Override
    public User editUserById(Long id) {
        Session session = sessionFactory.openSession();
        User user =  session.get(User.class, id);
        return user;
    }


    @Override
    public List<User> getAllUsers() {
        TypedQuery<User> query=sessionFactory.getCurrentSession().createQuery("from User");
        return query.getResultList();
    }
}