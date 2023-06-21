package com.aninfo.backend.proyectos.services;

import com.aninfo.backend.proyectos.exceptions.ProjectNotFoundException;
import com.aninfo.backend.proyectos.models.Project;
import com.aninfo.backend.proyectos.repositories.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProjectService {

    @Autowired
    ProjectRepository projectRepository;

    public Project createProject(Project project) {
        project.setId(0L);
        return projectRepository.save(project);
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
        try {
            this.findById(id);
            projectRepository.deleteById(id);
        } catch (ProjectNotFoundException e) {
            throw e;
        }
    }

    public void updateProject(Project project, Long id) {
        try {
            this.findById(id);
            project.setId(id);
            projectRepository.save(project);
        } catch (ProjectNotFoundException e) {
            throw e;
        }
    }
}
