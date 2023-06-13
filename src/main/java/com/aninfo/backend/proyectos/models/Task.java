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

    private Date due_date;
    private TaskPriority priority;
    private TaskStatus status;
    private int consumedHours;
}