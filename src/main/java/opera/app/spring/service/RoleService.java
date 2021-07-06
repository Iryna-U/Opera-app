package opera.app.spring.service;

import opera.app.spring.model.Role;

public interface RoleService {
    Role add(Role role);

    Role getRoleByName(String roleName);
}
