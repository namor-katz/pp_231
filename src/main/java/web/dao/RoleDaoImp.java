package web.dao;

import org.springframework.stereotype.Repository;
import web.model.Role;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceUnit;

import org.springframework.transaction.annotation.Transactional;

@Transactional
@Repository
public class RoleDaoImp implements RoleDao {

    @PersistenceContext
    private EntityManager em;   //OR @Autowired

    @Override
    public void add(Role roles) {
//        EntityManager em = emf.createEntityManager();
        em.persist(roles);
    }

    public Role getRoleById(Long id) {
//        EntityManager em = emf.createEntityManager();
        return em.find(Role.class, id);
    }
}
