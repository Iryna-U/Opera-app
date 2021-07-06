package opera.app.spring.dao;

import opera.app.spring.model.Role;

public interface RoleServiseDao {
    Role add(Role role);

    Role getRoleByName(String roleName);
}
