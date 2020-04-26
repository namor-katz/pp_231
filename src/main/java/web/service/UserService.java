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
        userDao.userAdd(user);
    }
}
