package web.service;

import org.springframework.beans.factory.annotation.Autowired;
import web.dao.RoleDao;
import web.model.Role;

public class RoleServiceImp implements RoleService{

    @Autowired
    private RoleDao roleDao;

    @Override
    public void add(Role roles) {
        roleDao.add(roles);
    }
}
