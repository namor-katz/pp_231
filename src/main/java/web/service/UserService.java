package web.service;

import web.model.User;

import java.util.List;

public interface UserService {
    public List<User> getUserList();
    public void save(User user);
    public void deleteById(Long id);
    public void editById(Long id, String name, String email, int maxWeigth);
    public User getUserById(Long id);
    public User getUserByName(String name);
}
