package web.dao;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import web.model.User;

import javax.persistence.TypedQuery;
import java.util.LinkedList;
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

    }

    @Override
    public User getUserById(Long id) {
        return null;
    }

    @Override
    public User getUserByName(String name) {
        return null;
    }

    @Override
    public boolean editUserById(Long id) {
        return false;
    }
/*
    public List<User> getAllUsers() throws HibernateException {
//        String hql = "from User";
        String hql = "FROM User";
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        List<User> AllUsers = session.createQuery(hql).list();
        tx.commit();
        session.close();
        return AllUsers;
    }

 */

    @Override
    public List<User> getAllUsers() {
        TypedQuery<User> query=sessionFactory.getCurrentSession().createQuery("from User");
        return query.getResultList();
    }
}