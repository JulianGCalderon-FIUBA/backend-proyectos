package com.aninfo.backend.proyectos.controllers;

import com.aninfo.backend.proyectos.exceptions.InvalidTaskAttributesException;
import com.aninfo.backend.proyectos.exceptions.TaskNotFoundException;
import com.aninfo.backend.proyectos.models.Task;
import com.aninfo.backend.proyectos.services.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/tasks")
@CrossOrigin()
public class TaskController {

    @Autowired
    TaskService taskService;

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Task getTask(@PathVariable Long id) {
        try {
            return taskService.findById(id);
        } catch(TaskNotFoundException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage(), e);
        }
    }

    @GetMapping("")
    @ResponseStatus(HttpStatus.OK)
    public Iterable<Task> getTasks(@RequestParam(required = false) List<Long> ids) {
        return taskService.getTasks(ids);
    }


    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void updateTask(@RequestBody Task task, @PathVariable Long id) {
        try {
            taskService.updateTask(task, id);
        } catch (TaskNotFoundException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage(), e);
        } catch (InvalidTaskAttributesException e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage(), e);
        }
    }

    @DeleteMapping("/{id}")
    public void deleteTask(@PathVariable Long id) {
        try {
            taskService.deleteTask(id);
        } catch (TaskNotFoundException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage(), e);
        }
    }

}