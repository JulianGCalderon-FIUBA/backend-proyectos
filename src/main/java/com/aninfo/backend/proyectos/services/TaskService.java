package com.aninfo.backend.proyectos.services;

import com.aninfo.backend.proyectos.models.Task;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Optional;

@Service
public class TaskService {

    public Optional<Task> findById(Long id) {
        // TODO
        return Optional.empty();
    }

    public void save(Task task) {
        // TODO
    }

    public void deleteById(Long id) {
        // TODO
    }

    public Task createTask(Task task, Long projectId) {
        // TODO
        return new Task();
    }

    public Collection<Task> getTasksForProject(Long id) {
        // TODO
        return new ArrayList<Task>() {{add(new Task());}};
    }

    public boolean existsTask(Long id) {
        // TODO
        return true;
    }

    public void updateTask(Task task, Long id) {
        // TODO
    }
}
