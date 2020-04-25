package web.dao;

import web.model.User;
import java.util.List;

public interface userDao {
    public void userAdd(User user);
    public void deleteUserById(Long id);
    public User getUserById(Long id);
    public User getUserByName(String name);
    public boolean editUserById(Long id);
    public List<User> getAllUsers();
}
