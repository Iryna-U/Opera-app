package opera.dao;

import opera.model.Role;

public interface RoleServiseDao {
    Role add(Role role);

    Role getRoleByName(String roleName);
}
