package web.service;

import web.model.User;

import java.util.LinkedList;
import java.util.List;

public class UserService {

    private static UserService userService;

    public static UserService getInstance()  {
        if (userService == null) {
            userService = new UserService();
        }
        return userService;
    }

    public List<User> getUserList() {

        List<User> list = new LinkedList<>();

        User user = new User("ivan", "govnov@mail.com", "123", 150);
        User user2 = new User("Andrei", "ivanov@yandex.ru", "123", 156);
        list.add(user);
        list.add(user2);
        return list;
    }
}
