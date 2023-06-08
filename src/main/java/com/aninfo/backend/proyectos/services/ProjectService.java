package com.aninfo.backend.proyectos.services;

import com.aninfo.backend.proyectos.models.Project;
import com.aninfo.backend.proyectos.models.Task;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Optional;

@Service
public class ProjectService {

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

    public Task createTaskById(Task task, Long id) {
        // TODO
        return new Task();
    }

    public Collection<Task> getTasksById(Long id) {
        // TODO
        return new ArrayList<Task>() {{add(new Task()); }};
    }
}
