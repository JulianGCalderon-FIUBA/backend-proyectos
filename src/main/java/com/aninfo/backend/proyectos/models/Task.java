package com.aninfo.backend.proyectos.models;
import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "task")
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne()
    @JoinColumn(name="project_id", nullable = false)
    private Project project;

    private String name;

    private String description;

    @Column(name = "due_date")
    private Date dueDate;
    private TaskPriority priority;
    private TaskState state;

    @Column(name = "consumed_hours")
    private int consumedHours;

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

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }

    public TaskState getState() {
        return state;
    }

    public void setState(TaskState state) {
        this.state = state;
    }
}