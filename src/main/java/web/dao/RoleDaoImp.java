package web.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import web.model.Role;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Set;

//@Transactional
@Repository
public class RoleDaoImp implements RoleDao {

//    @Autowired
//    private SessionFactory sessionFactory;

    //
    @PersistenceContext
    private EntityManager em;   //OR @Autowired
    //

    @Override
    public void add(Role roles) {
//        sessionFactory.getCurrentSession().save(roles);
        em.persist(roles);
    }

    public Role getRoleById(Long id) {
        //Role role = sessionFactory.getCurrentSession().load(Role.class, id);
        return em.find(Role.class, id);
//        return role;
    }
}
