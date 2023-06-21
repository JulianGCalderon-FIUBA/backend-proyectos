package com.aninfo.backend.proyectos.services;

import com.aninfo.backend.proyectos.exceptions.InvalidProjectAttributesException;
import com.aninfo.backend.proyectos.exceptions.ProjectNotFoundException;
import com.aninfo.backend.proyectos.models.Project;
import com.aninfo.backend.proyectos.repositories.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Date;

@Service
public class ProjectService {

    @Autowired
    ProjectRepository projectRepository;

    private boolean projectHasValidAttributes(Project project) {
        Date endDate = project.getEndDate();
        Date startDate = project.getStartDate();

        return project.getConsumedHours() >= 0 && startDate.compareTo(endDate) <= 0;
    }

    private Project saveProjectWithId(Project project, Long id) {
        if (!projectHasValidAttributes(project)) {
            throw new InvalidProjectAttributesException("Project does not have valid attributes");
        }
        project.setId(id);
        return projectRepository.save(project);
    }

    public Project createProject(Project project) {
        return saveProjectWithId(project, 0L);
    }

    public Iterable<Project> getProjects() {
        return projectRepository.findAll();
    }

    public Project findById(Long id) {
        Optional<Project> project = projectRepository.findById(id);
        if (project.isEmpty()) {
            throw new ProjectNotFoundException("Project not found with ID: " + id);
        }
        return project.get();
    }

    public void deleteProject(Long id) {
        this.findById(id);
        projectRepository.deleteById(id);
    }

    public void updateProject(Project project, Long id) {
        this.findById(id);
        saveProjectWithId(project, id);
    }
}
