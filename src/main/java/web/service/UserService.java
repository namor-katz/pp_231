package web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import web.dao.UserDao;
import web.model.User;
import java.util.List;

@Service    //можно
@Transactional  //нужно ли?
public class UserService {

    @Autowired
    UserDao userDao;

    public List<User> getUserList() {
        return userDao.getAllUsers();
    }

    public void save(User user) {
        //т.к. в веб-форме admin, а в таблице, с какого-то хуя должен быть ROLE_admin, переебеним так.
        if(user.getRoles().equals("admin")) {
            user.setRoles("ROLE_admin");
        }
        else if(user.getRoles().equals("user")) {
            user.setRoles("ROLE_user");
        }
        userDao.userAdd(user);
    }

    public void deleteById(Long id) {
        userDao.deleteUserById(id);
    }

    public void editById(Long id, String name, String email, int maxWeight) {
        userDao.editUserById(id, name, email, maxWeight);
    }

    public User getUserById(Long id ) {
        return userDao.getUserById(id);
    }
}
