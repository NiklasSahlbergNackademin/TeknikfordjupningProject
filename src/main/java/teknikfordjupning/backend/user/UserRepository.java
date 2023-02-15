package teknikfordjupning.backend.user;

import org.springframework.data.jpa.repository.JpaRepository;
import teknikfordjupning.backend.model.User;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Integer> {
    Optional<User> findByEmail (String email);
}
