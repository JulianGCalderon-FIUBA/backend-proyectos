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

    private void assertProjectHasValidAttributes(Project project) {
        if (project.getName() == null) {
            throw new InvalidProjectAttributesException("Project cannot have null name");
        }
        if (project.getConsumedHours() < 0){
            throw new InvalidProjectAttributesException("Project cannot have negative consumed hours");
        }
        if (project.getStartDate() == null) {
            throw new InvalidProjectAttributesException("Project cannot have null start date");
        }
        if (project.getState() == null) {
            throw new InvalidProjectAttributesException("Project cannot have null state");
        }

        Date endDate = project.getEndDate();
        Date startDate = project.getStartDate();
        if(endDate != null && startDate.compareTo(endDate) > 0) {
           throw new InvalidProjectAttributesException("Project's end date cannot be before start date");
        }
    }

    private Project saveProjectWithId(Project project, Long id) {
        assertProjectHasValidAttributes(project);
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
