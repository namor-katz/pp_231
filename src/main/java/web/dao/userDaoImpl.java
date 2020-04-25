package web.dao;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import web.model.User;
import java.util.List;

@Repository
public class userDaoImpl implements userDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void userAdd(User user) {

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
        return null;
    }
}