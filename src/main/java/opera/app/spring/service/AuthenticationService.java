package opera.app.spring.service;

import opera.app.spring.model.User;

public interface AuthenticationService {
    User register(String email, String password);
}
