package web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import web.dao.RoleDao;
import web.dao.UserDao;
import web.model.Role;
import web.model.User;

import java.util.*;

@Service
public class UserServiceImp implements UserDetailsService, UserService {

    @Autowired
    UserDao userDao;

    @Autowired
    RoleDao roleDao;

    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;

    public List<User> getUserList() {
        return userDao.getAllUsers();
    }

    public void save(User user) {
        System.out.println(user.getEmail());
        Set<Role> set = new HashSet<>();
        if(user.getRoles().size() > 0) {
            set.add(roleDao.getRoleById(1L));
            set.add(roleDao.getRoleById(2L));
        }
        else {
            set.add(roleDao.getRoleById(1L));
        }
        user.setRoles(set);
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        userDao.userAdd(user);
    }

    public void deleteById(Long id) {
        userDao.deleteUserById(id);
    }

    public void editById(Long id, String name, String email, int maxWeight) {
        userDao.editUserById(id, name, email, maxWeight);
    }

    public User getUserById(Long id) {
        return userDao.getUserById(id);
    }

    public User getUserByName(String name) {
       return userDao.getUserByName(name);
    }
    //add override methods

    @Override
    public UserDetails loadUserByUsername(String name) throws UsernameNotFoundException {
        User user = userDao.getUserByName(name);
        if (user == null) {
            throw new UsernameNotFoundException("This user not found");
        }

        return user;
    }

}
