package com.aninfo.backend.proyectos.services;

import com.aninfo.backend.proyectos.models.Project;
import com.aninfo.backend.proyectos.repositories.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Optional;

@Service
public class ProjectService {

    @Autowired
    ProjectRepository projectRepository;

    public Project createProject(Project project) {
        // TODO
        return new Project();
    }

    public Collection<Project> getProjects() {
        // TODO
        return new ArrayList<>() {{add(new Project()); }};
    }

    public Optional<Project> findById(Long id) {
        // TODO
        return Optional.empty();
    }


    public void deleteById(Long id) {
        // TODO
    }

    public void updateById(Project project, Long id) {
        // TODO
    }
}
