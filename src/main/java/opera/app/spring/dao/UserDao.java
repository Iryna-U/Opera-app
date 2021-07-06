package opera.app.spring.dao;

import java.util.Optional;
import opera.app.spring.model.User;

public interface UserDao {
    User add(User user);

    Optional<User> get(Long id);

    Optional<User> findByEmail(String email);
}
