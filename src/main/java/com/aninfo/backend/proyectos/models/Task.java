package com.aninfo.backend.proyectos.models;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "task")
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "project_id")
    private Long projectId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "project_id", insertable = false, updatable = false)
    @JsonIgnore
    private Project project;

    private String name;

    private String description;

    @Column(name = "resource_id")
    private Long resourceId;

    @Column(name = "due_date")
    private Date dueDate;
    private TaskPriority priority = TaskPriority.Medium;
    private TaskState state = TaskState.NotStarted;

    @Column(name = "consumed_hours")
    private int consumedHours = 0;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getDueDate() {
        return dueDate;
    }

    public void setDueDate(Date due_date) {
        this.dueDate = due_date;
    }

    public TaskPriority getPriority() {
        return priority;
    }

    public void setPriority(TaskPriority priority) {
        this.priority = priority;
    }

    public int getConsumedHours() {
        return consumedHours;
    }

    public void setConsumedHours(int consumedHours) {
        this.consumedHours = consumedHours;
    }

    public TaskState getState() {
        return state;
    }

    public void setState(TaskState state) {
        this.state = state;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Long getId() {
        return this.id;
    }

    public void setProject(Project project) {
        this.project = project;
        this.projectId = project.getId();
    }

    public Long getProjectId() {
        return projectId;
    }

    public Long getResourceId() {
        return resourceId;
    }

    public void setResourceId(Long resourceId) {
        this.resourceId = resourceId;
    }
}