package opera.app.spring.controller;

import java.time.LocalDateTime;
import java.util.Set;
import opera.app.spring.model.Role;
import opera.app.spring.model.User;
import opera.app.spring.service.AuthenticationService;
import opera.app.spring.service.RoleService;
import opera.app.spring.service.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/inject")
public class InjectController {
    private final RoleService roleService;
    private final AuthenticationService authenticationService;
    private final UserService userService;

    public InjectController(RoleService roleService,
                            AuthenticationService authenticationService,
                            UserService userService) {
        this.roleService = roleService;
        this.authenticationService = authenticationService;
        this.userService = userService;
    }

    @GetMapping
    public String inject() {
        System.out.println(LocalDateTime.now() + "  inject start");
        roleService.add(new Role(Role.RoleName.ADMIN));
        roleService.add(new Role(Role.RoleName.USER));
        authenticationService.register("bob@gmail.com", "1234");

        User alice = new User();
        alice.setEmail("alise@gmail.com");
        alice.setPassword("1234");
        alice.setRoles(Set.of(roleService.getRoleByName("ADMIN")));
        userService.add(alice);
        return "Done!!!";
    }

}
