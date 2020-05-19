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
        em.persist(user);
    }

    @Override
    public void deleteUserById(Long id) {
        User user = em.find(User.class, id);
        em.remove(user);
    }

    public void deleteUser(User user) {
        Long id = user.getId();
        deleteUserById(id);
    }

    @Transactional(readOnly = true)
    @Override
    public User getUserById(Long id) {
        return em.find(User.class, id);
    }

    @Transactional(readOnly = true)
    @Override
    public User getUserByName(String name) {
        TypedQuery<User> query = em.createQuery("select u from User u where u.name = :name", User.class);
        query.setParameter("name", name);
        return query.getSingleResult();
    }

    @Override
    public void editUserById(Long id, String name, String email, int maxweigth) {
        User user = getUserById(id);
        user.setName(name);
        user.setEmail(email);
        user.setMaxweight(maxweigth);
        em.merge(user);

    }

    @Transactional(readOnly = true)
    @Override
    public List<User> getAllUsers() {
        TypedQuery<User> query = em.createQuery("select u from User u", User.class);
        return query.getResultList();
    }
}