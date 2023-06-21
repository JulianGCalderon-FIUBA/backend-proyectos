package com.aninfo.backend.proyectos.services;

import com.aninfo.backend.proyectos.exceptions.ProjectNotFoundException;
import com.aninfo.backend.proyectos.exceptions.TaskNotFoundException;
import com.aninfo.backend.proyectos.models.Project;
import com.aninfo.backend.proyectos.models.Task;
import com.aninfo.backend.proyectos.repositories.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Optional;

@Service
public class TaskService {

    @Autowired
    TaskRepository taskRepository;

    @Autowired
    ProjectService projectService;

    public Task findById(Long id) {
        Optional<Task> task = taskRepository.findById(id);
        if (task.isEmpty()) {
            throw new TaskNotFoundException("Task not found with ID: " + id);
        }
        return task.get();
    }

    public void deleteTask(Long id) {
        try {
            this.findById(id);
            taskRepository.deleteById(id);
        } catch (TaskNotFoundException e) {
            throw e;
        }
    }

    public Task createTask(Task task, Long projectId) {
        task.setId(0L);
        try {
            Project project = projectService.findById(projectId);
            task.setProject(project);
            return taskRepository.save(task);
        } catch (ProjectNotFoundException e) {
            throw e;
        }
    }

    public Collection<Task> getTasksForProject(Long projectId) {
        try {
            projectService.findById(projectId);
            return taskRepository.findAllByProjectId(projectId);
        } catch (ProjectNotFoundException e) {
            throw e;
        }
    }

    public void updateTask(Task task, Long id) {
        try {
            this.findById(id);
            task.setId(id);
            taskRepository.save(task);
        } catch (TaskNotFoundException e) {
            throw e;
        }
    }
}
