package web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import web.dao.RoleDao;
import web.dao.UserDao;
import web.model.Role;
import web.model.User;
import java.util.List;
import java.util.Collections;

@Service    //можно
//@Transactional  //нужно ли?
public class UserService implements UserDetailsService {

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
        try {
        if(user.getRoles().equals("admin")) {
            user.setRoles(Collections.singleton(new Role(1L, "ROLE_admin")));
        }
        else if(user.getRoles().equals("user")) {
            user.setRoles(Collections.singleton(new Role(1L, "ROLE_user")));
        }
        userDao.userAdd(user);
    } catch (Exception e) {
        e.printStackTrace();
        }
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

    //add override methods

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        User user = userDao.getUserByName(s);
        if (user == null) {
            throw new UsernameNotFoundException("This user not found");
        }

        return user;
    }

}
