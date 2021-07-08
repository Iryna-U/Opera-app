package opera.controller;

import java.time.LocalDateTime;
import java.util.Set;
import opera.model.Performance;
import opera.model.PerformanceSession;
import opera.model.Role;
import opera.model.Stage;
import opera.model.User;
import opera.service.AuthenticationService;
import opera.service.PerformanceService;
import opera.service.PerformanceSessionService;
import opera.service.RoleService;
import opera.service.StageService;
import opera.service.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/inject")
public class InjectController {
    private final RoleService roleService;
    private final AuthenticationService authenticationService;
    private final UserService userService;
    private final StageService stageService;
    private final PerformanceService performanceService;
    private final PerformanceSessionService performanceSessionService;

    public InjectController(RoleService roleService,
                            AuthenticationService authenticationService,
                            UserService userService, StageService stageService,
                            PerformanceService performanceService,
                            PerformanceSessionService performanceSessionService) {
        this.roleService = roleService;
        this.authenticationService = authenticationService;
        this.userService = userService;
        this.stageService = stageService;
        this.performanceService = performanceService;
        this.performanceSessionService = performanceSessionService;
    }

    @GetMapping
    public String inject() {
        roleService.add(new Role(Role.RoleName.ADMIN));
        roleService.add(new Role(Role.RoleName.USER));
        authenticationService.register("bob@gmail.com", "1234");

        User alice = new User();
        alice.setEmail("alise@gmail.com");
        alice.setPassword("1234");
        alice.setRoles(Set.of(roleService.getRoleByName("ADMIN")));
        userService.add(alice);

        Stage stage = new Stage();
        stage.setCapacity(100);
        stage.setDescription("Beautiful stage");

        Performance performance = new Performance();
        performance.setTitle("Master and Margarita");
        performance.setDescription("Good performance");

        Stage stageFromDb = stageService.add(stage);
        Performance performanceFromDb = performanceService.add(performance);

        PerformanceSession performanceSession = new PerformanceSession();
        performanceSession.setPerformance(performanceFromDb);
        performanceSession.setStage(stageFromDb);
        performanceSession.setShowTime(LocalDateTime.now());
        performanceSessionService.add(performanceSession);
        return "Done!!!";
    }
}
