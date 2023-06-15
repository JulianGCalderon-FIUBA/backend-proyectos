package com.aninfo.backend.proyectos.services;

import com.aninfo.backend.proyectos.models.Project;
import com.aninfo.backend.proyectos.models.Task;
import com.aninfo.backend.proyectos.repositories.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
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

    public Optional<Project> findById(Long id) {
        return projectRepository.findById(id);
    }


    public void deleteProject(Long id) {
        projectRepository.deleteById(id);
    }

    public Project updateProject(Project project, Long id) {
        project.setId(id);
        return projectRepository.save(project);
    }
}
