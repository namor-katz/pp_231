package web.dao;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import web.model.User;
import javax.persistence.*;
import java.util.List;

@SuppressWarnings("JpaQlInspection")
@Repository
@Transactional
public class UserDaoImpl implements UserDao {
    @PersistenceContext
    private EntityManager em;

    @Override
    public void userAdd(User user) {
//        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(user);
        em.getTransaction().commit();
    }

    @Override
    public void deleteUserById(Long id) {
//        EntityManager em = emf.createEntityManager();
        User user = em.find(User.class, id);
        em.getTransaction().begin();
        em.remove(user);
        em.getTransaction().commit();
    }

    public void deleteUser(User user) {
        Long id = user.getId();
        deleteUserById(id);
    }

    @Transactional(readOnly = true)
    @Override
    public User getUserById(Long id) {
//        EntityManager em = emf.createEntityManager();
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

    @Transactional(readOnly = true)
    @Override
    public User getUserByName(String name) {
//        EntityManager em = emf.createEntityManager();
        TypedQuery<User> query = em.createQuery("select u from User u where u.name = :name", User.class);
        query.setParameter("name", name);
        return query.getSingleResult();
    }

    @Override
    public void editUserById(Long id, String name, String email, int maxweigth) {
//        EntityManager em = emf.createEntityManager();
        User user = getUserById(id);
        user.setName(name);
        user.setEmail(email);
        user.setMaxweight(maxweigth);
        em.getTransaction().begin();
        em.merge(user);
        em.getTransaction().commit();

    }

    @Transactional(readOnly = true)
    @Override
    public List<User> getAllUsers() {
//        EntityManager em = emf.createEntityManager();
        TypedQuery<User> query = em.createQuery("select u from User u", User.class);
        return query.getResultList();
    }
}