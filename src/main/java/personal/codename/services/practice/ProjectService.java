package personal.codename.services.practice;

import personal.codename.domain.models.practice.Project;

import java.util.List;
import java.util.Optional;

public interface ProjectService {
    List<Project> getAllProjects();

    Optional<Project> getProjectById(Long id);

    Project saveProject(Project project);

    void deleteProject(Long id);
}
