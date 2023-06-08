package com.aninfo.backend.proyectos.services;

import com.aninfo.backend.proyectos.models.Project;
import com.aninfo.backend.proyectos.repositories.MyRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Optional;

@Service
public class ProjectService {

    private MyRepository projectRepository;

    public Project createProject(Project project) {
        // TODO
        return new Project();
    }

    public Collection<Project> getProjects() {
        // TODO
        return new ArrayList<Project>() {{add(new Project()); }};
    }

    public Optional<Project> findById(Long id) {
        // TODO
        return Optional.empty();
    }

    public void save(Project project) {
        // TODO
    }

    public void deleteById(Long id) {
        // TODO
    }
}
