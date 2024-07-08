package personal.codename.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import personal.codename.domain.models.Player;

public interface PlayerRepository extends JpaRepository<Player, Long> {
    
}
