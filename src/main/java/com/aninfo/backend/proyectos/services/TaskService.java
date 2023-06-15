package com.aninfo.backend.proyectos.services;

import com.aninfo.backend.proyectos.models.Project;
import com.aninfo.backend.proyectos.models.Task;
import com.aninfo.backend.proyectos.repositories.ProjectRepository;
import com.aninfo.backend.proyectos.repositories.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Optional;

@Service
public class TaskService {

    @Autowired
    TaskRepository taskRepository;
    @Autowired
    ProjectRepository projectRepository;

    public Optional<Task> findById(Long id) {
        return taskRepository.findById(id);
    }

    public void deleteTask(Long id) {
        taskRepository.deleteById(id);
    }

    public Task createTask(Task task, Long projectId) {
        task.setId(0L);
        Project project = projectRepository.findById(projectId).orElseThrow(() -> new IllegalArgumentException("Project not found"));
        task.setProject(project);
        System.out.printf("Task Name: %s\n", task.getName());
        System.out.println(task.getProjectId());
        return taskRepository.save(task);
    }

    public Collection<Task> getTasksForProject(Long projectId) {
        return taskRepository.findAllByProjectId(projectId);
    }

    public Task updateTask(Task task, Long id) {
        task.setId(id);
        return taskRepository.save(task);
    }
}
