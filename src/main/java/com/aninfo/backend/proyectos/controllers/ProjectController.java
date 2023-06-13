package com.aninfo.backend.proyectos.controllers;

import com.aninfo.backend.proyectos.models.Project;
import com.aninfo.backend.proyectos.models.Task;
import com.aninfo.backend.proyectos.services.ProjectService;
import com.aninfo.backend.proyectos.services.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.Optional;

@RestController
@RequestMapping("/projects")
public class ProjectController {

    @Autowired
    ProjectService projectService;
    @Autowired
    TaskService taskService;

    @PostMapping("")
    @ResponseStatus(HttpStatus.CREATED)
    public Project createProject(@RequestBody Project project) {
        return projectService.createProject(project);
    }

    @GetMapping("")
    @ResponseStatus(HttpStatus.OK)
    public Collection<Project> getProjects() {
        return projectService.getProjects();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Project> getProject(@PathVariable Long id) {
        Optional<Project> projectOptional = projectService.findById(id);
        return ResponseEntity.of(projectOptional);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Project> updateProject(@RequestBody Project project, @PathVariable Long id) {
        if (projectService.findById(id).isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        projectService.updateById(project, id);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public void deleteProject(@PathVariable Long id) {
        projectService.deleteById(id);
    }

    @PostMapping("/{id}/tasks")
    @ResponseStatus(HttpStatus.CREATED)
    public Task createTask(@RequestBody Task task, @PathVariable Long id) {
        return taskService.createTask(task, id);
    }

    @GetMapping("/{id}/tasks")
    public Collection<Task> getTasks(@PathVariable Long id) {
        return taskService.getTasksForProject(id);
    }
}