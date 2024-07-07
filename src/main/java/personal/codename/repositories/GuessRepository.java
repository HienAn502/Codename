package personal.codename.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import personal.codename.domain.models.Guess;

public interface GuessRepository extends JpaRepository<Guess, Long> {
}
