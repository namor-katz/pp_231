package web.dao;

import web.model.User;
import java.util.List;

public interface UserDao {
    public void userAdd(User user);
    public void deleteUserById(Long id);
    public User getUserById(Long id);
    public User getUserByName(String name);
    public void editUserById(Long id, String name, String email, int maxWeitht);
    public List<User> getAllUsers();
}
