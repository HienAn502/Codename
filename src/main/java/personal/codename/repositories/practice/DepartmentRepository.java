package personal.codename.repositories.practice;

import org.springframework.data.jpa.repository.JpaRepository;
import personal.codename.domain.models.practice.Department;

public interface DepartmentRepository extends JpaRepository<Department, Integer> {
}
