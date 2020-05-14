package web.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import web.model.Role;
import java.util.Set;

@Repository
public class RoleDaoImp implements RoleDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void add(Role roles) {
        sessionFactory.getCurrentSession().save(roles);
    }

    public Role getRoleById(Long id) {
        Role role = (Role) sessionFactory.getCurrentSession().load(Role.class, id);
        return role;
    }
}
