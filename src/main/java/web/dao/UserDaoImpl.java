package web.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
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

    @Override
    public List<User> getAllUsers() {
        TypedQuery<User> query=sessionFactory.getCurrentSession().createQuery("from User");
        return query.getResultList();
    }
}