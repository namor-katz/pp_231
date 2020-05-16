package web.dao;

import org.hibernate.query.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import web.model.User;

import javax.persistence.*;
import java.util.List;

@SuppressWarnings("JpaQlInspection")
@Repository
@Transactional
public class UserDaoImpl implements UserDao {
/*
    @Autowired
    SessionFactory sessionFactory;
*/


    //test
//    @Autowired
//    @PersistenceContext
    @PersistenceUnit
    private EntityManagerFactory emf;
    //test

    @Override
    public void userAdd(User user) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(user);
        em.getTransaction().commit();
        /*
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(user);
        session.getTransaction().commit();
        session.close();

         */
    }

    @Override
    public void deleteUserById(Long id) {
        EntityManager em = emf.createEntityManager();
        User user = em.find(User.class, id);
        em.getTransaction().begin();
        em.remove(user);
        em.getTransaction().commit();
/*
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        Query q = session.createQuery("delete User where id = :id");
        q.setParameter("id", id);
        int i = q.executeUpdate();
        transaction.commit();
        session.close();
 */
    }

    public void deleteUser(User user) {
        Long id = user.getId();
        deleteUserById(id);
//        Session session = sessionFactory.openSession();
//        session.delete(user);
    }

    @Override
    public User getUserById(Long id) {
        EntityManager em = emf.createEntityManager();
        return em.find(User.class, id);
        /*
        String hql = "from User where id = :id";
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        Query q = session.createQuery(hql);
        q.setParameter("id", id);
        List<User> list = q.list();
        tx.commit();
        session.close();
        return list.get(0);*/
    }


    @Override
//    @Transactional(readOnly = true)
    public User getUserByName(String name) {
        EntityManager em = emf.createEntityManager();
        TypedQuery<User> query = em.createQuery("select u from User u where u.name = :name", User.class);
        query.setParameter("name", name);
        return query.getSingleResult();
        /*String hql = "from User where name = :name";
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        Query q = session.createQuery(hql);
        q.setParameter("name", name);
        List<User> list = q.list();
        tx.commit();
        session.close();
        User user = list.get(0);
        return user;*/
    }

    @Override
    public void editUserById(Long id, String name, String email, int maxweigth) {
        EntityManager em = emf.createEntityManager();
        User user = getUserById(id);
        user.setName(name);
        user.setEmail(email);
        user.setMaxweight(maxweigth);
        em.getTransaction().begin();
        em.merge(user);
        em.getTransaction().commit();

        /*
        String hql = "update User set name = :name, email = :email, maxweight = :maxweight where id = :id";
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        Query q = session.createQuery(hql);
        q.setParameter("id", id);
        q.setParameter("name", name);
        q.setParameter("email", email);
        q.setParameter("maxweight", maxweigth);
        q.executeUpdate();
        tx.commit();
        session.close();
*/
    }

    @Override
//    @Transactional(readOnly = true)
    public List<User> getAllUsers() {
        EntityManager em = emf.createEntityManager();
        TypedQuery<User> query = em.createQuery("select u from User u", User.class);
        return query.getResultList();
//        TypedQuery<User> query=sessionFactory.openSession().createQuery("from User");
//        return query.getResultList();
    }
}