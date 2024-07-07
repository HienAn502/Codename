package personal.codename.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import personal.codename.domain.models.User;

public interface UserRepository extends JpaRepository<User, Long> {
}
