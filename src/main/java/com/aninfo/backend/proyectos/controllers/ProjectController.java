package com.aninfo.backend.proyectos.controllers;

import com.aninfo.backend.proyectos.exceptions.InvalidProjectAttributesException;
import com.aninfo.backend.proyectos.exceptions.InvalidTaskAttributesException;
import com.aninfo.backend.proyectos.exceptions.ProjectNotFoundException;
import com.aninfo.backend.proyectos.models.Project;
import com.aninfo.backend.proyectos.models.Task;
import com.aninfo.backend.proyectos.services.ProjectService;
import com.aninfo.backend.proyectos.services.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.Collection;

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
        try {
            return projectService.createProject(project);
        } catch (InvalidProjectAttributesException e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage(), e);
        }

    }

    @GetMapping("")
    @ResponseStatus(HttpStatus.OK)
    public Iterable<Project> getProjects() {
        return projectService.getProjects();
    }

    @GetMapping("/{id}")
    public Project getProject(@PathVariable Long id) {
        try {
            return projectService.findById(id);
        } catch(ProjectNotFoundException e) {
            System.out.println("Error while getting project with id: " + id);
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage(), e);
        }
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void updateProject(@RequestBody Project project, @PathVariable Long id) {
        try {
            projectService.updateProject(project, id);
        } catch (ProjectNotFoundException e) {
            System.out.println("Error while updating project with id: " + id);
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage(), e);
        } catch (InvalidProjectAttributesException e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage(), e);
        }
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteProject(@PathVariable Long id) {
        try {
            projectService.deleteProject(id);
        } catch (ProjectNotFoundException e) {
            System.out.println("Error while deleting project with id: " + id);
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage(), e);
        }
    }

    @PostMapping("/{id}/tasks")
    @ResponseStatus(HttpStatus.CREATED)
    public Task createTaskForProject(@RequestBody Task task, @PathVariable("id") Long projectId) {
        try {
            return taskService.createTask(task, projectId);
        } catch (ProjectNotFoundException e) {
            System.out.println("Error while creating task for project with id: " + projectId);
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage(), e);
        } catch (InvalidTaskAttributesException e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage(), e);
        }
    }

    @GetMapping("/{id}/tasks")
    public Collection<Task> getTasks(@PathVariable("id") Long projectId) {
        try {
            return taskService.getTasksForProject(projectId);
        } catch (ProjectNotFoundException e) {
            System.out.println("Error while getting tasks for project with id: " + projectId);
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage(), e);
        }
    }
}