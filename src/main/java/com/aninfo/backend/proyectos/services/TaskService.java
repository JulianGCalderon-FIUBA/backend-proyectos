package com.aninfo.backend.proyectos.services;

import com.aninfo.backend.proyectos.exceptions.InvalidTaskAttributesException;
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

    private boolean taskHasValidAttributes(Task task) {
        return task.getConsumedHours() >= 0;
    }

    private Task saveTaskWithId(Task task, Long id) {
        if (!taskHasValidAttributes(task)) {
            throw new InvalidTaskAttributesException("Task does not have valid attributes");
        }
        task.setId(id);
        return taskRepository.save(task);
    }

    public Task findById(Long id) {
        Optional<Task> task = taskRepository.findById(id);
        if (task.isEmpty()) {
            throw new TaskNotFoundException("Task not found with ID: " + id);
        }
        return task.get();
    }

    public void deleteTask(Long id) {
        this.findById(id);
        taskRepository.deleteById(id);
    }

    public Task createTask(Task task, Long projectId) {
        Project project = projectService.findById(projectId);
        task.setProject(project);
        return saveTaskWithId(task,0L);
    }

    public Collection<Task> getTasksForProject(Long projectId) {
        projectService.findById(projectId);
        return taskRepository.findAllByProjectId(projectId);
    }

    public void updateTask(Task task, Long id) {
        this.findById(id);
        saveTaskWithId(task, id);
    }
}
