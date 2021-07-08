package opera.dao.impl;

import opera.model.Role;
import opera.model.User;
import opera.service.UserService;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserDetailsService {
    private final UserService userService;

    public CustomUserDetailsService(UserService userService) {
        this.userService = userService;
    }

    @Override
    public UserDetails loadUserByUsername(String email) {
        User user = userService.findByEmail(email);

        org.springframework.security.core.userdetails.User.UserBuilder builder =
                org.springframework.security.core.userdetails.User.withUsername(email);
        builder.password(user.getPassword());
        String[] roles = user.getRoles()
                .stream()
                .map(Role::getRoleName)
                .map(String::valueOf)
                .toArray(String[]::new);
        builder.roles(roles);
        return builder.build();
    }
}
