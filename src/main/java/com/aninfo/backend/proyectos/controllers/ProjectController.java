package com.aninfo.backend.proyectos.controllers;

import com.aninfo.backend.proyectos.models.Project;
import com.aninfo.backend.proyectos.services.ProjectService;
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

    @PostMapping("")
    @ResponseStatus(HttpStatus.CREATED)
    public Project createProject(@RequestBody Project project) {
        return projectService.createProject(project);
    }

    @GetMapping("")
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
        Optional<Project> projectOptional = projectService.findById(id);

        if (!projectOptional.isPresent()) {
            return ResponseEntity.notFound().build();
        }

        projectService.save(project);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public void deleteProject(@PathVariable Long id) {
        projectService.deleteById(id);
    }
}