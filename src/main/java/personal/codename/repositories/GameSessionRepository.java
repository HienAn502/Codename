package personal.codename.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import personal.codename.domain.models.GameSession;

public interface GameSessionRepository extends JpaRepository<GameSession, Long> {
}
