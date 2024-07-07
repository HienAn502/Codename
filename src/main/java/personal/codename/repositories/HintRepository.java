package personal.codename.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import personal.codename.domain.models.Hint;

public interface HintRepository extends JpaRepository<Hint, Long> {
}
