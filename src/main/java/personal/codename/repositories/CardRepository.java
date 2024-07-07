package personal.codename.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import personal.codename.domain.models.Card;

public interface CardRepository extends JpaRepository<Card, Long> {
}
