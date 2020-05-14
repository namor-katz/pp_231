package web.dao;

import web.model.Role;

public interface RoleDao {
    void add(Role roles);
    public Role getRoleById(Long id);
}
