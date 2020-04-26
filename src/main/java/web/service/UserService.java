package web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import web.dao.UserDao;
import web.model.User;

import java.util.LinkedList;
import java.util.List;

@Service    //можно
@Transactional  //нужно ли?
public class UserService {

    private static UserService userService;

    @Autowired
    UserDao userDao;

    public static UserService getInstance()  {
        if (userService == null) {
            userService = new UserService();
        }
        return userService;
    }

    private List<User> list = new LinkedList<>();

    public List<User> getUserList() {

//        List<User> list = new LinkedList<>();

        User user = new User("ivan", "govnov@mail.com", "123", 150);
        User user2 = new User("Andrei", "ivanov@yandex.ru", "123", 156);
        list.add(user);
        list.add(user2);
        return list;
    }

    public void save(User user) {
//        list.add(user);
        userDao.userAdd(user);
    }
}
