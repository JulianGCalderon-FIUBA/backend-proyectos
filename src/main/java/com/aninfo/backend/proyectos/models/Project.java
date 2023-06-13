package com.aninfo.backend.proyectos.models;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "project")
public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany(mappedBy = "project", cascade = CascadeType.ALL)
    private Collection<Task> tasks;

    private String name;
    private String description;

    @Column(name = "consumed_hours")
    private int consumedHours;

    public String getName() {
        return name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public int getConsumedHours() {
        return consumedHours;
    }

    public void setConsumedHours(int consumedHours) {
        this.consumedHours = consumedHours;
    }
}