package com.aninfo.backend.proyectos.models;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "project")
public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany(mappedBy = "task", cascade = CascadeType.ALL, orphanRemoval = true)
    private Collection<Task> tasks;

    private String name;
    private String description;
    private int consumedHours;
}