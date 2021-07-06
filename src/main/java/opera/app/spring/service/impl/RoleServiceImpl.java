package opera.app.spring.service.impl;

import opera.app.spring.dao.RoleServiseDao;
import opera.app.spring.model.Role;
import opera.app.spring.service.RoleService;
import org.springframework.stereotype.Service;

@Service
public class RoleServiceImpl implements RoleService {
    private final RoleServiseDao roleServiseDao;

    public RoleServiceImpl(RoleServiseDao roleServiseDao) {
        this.roleServiseDao = roleServiseDao;
    }

    @Override
    public Role add(Role role) {
        return roleServiseDao.add(role);
    }

    @Override
    public Role getRoleByName(String roleName) {
        return roleServiseDao.getRoleByName(roleName);
    }
}
