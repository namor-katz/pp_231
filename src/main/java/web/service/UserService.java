package web.service;

import web.model.User;

import java.util.LinkedList;
import java.util.List;

public class UserService {
    public List<User> getUserList() {

        List<User> list = new LinkedList<>();

        User user = new User("ivan", "govnov@mail.com");
        list.add(user);
        return list;
    }
}
