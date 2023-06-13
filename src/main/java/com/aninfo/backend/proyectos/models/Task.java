package com.aninfo.backend.proyectos.models;

import javax.persistence.*;

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
    private int priority;
    private int status;
    private int consumedHours;
}