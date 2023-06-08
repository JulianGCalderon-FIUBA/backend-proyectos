package com.aninfo.backend.proyectos.models;

import javax.persistence.*;

@Entity
@Table(name = "element")
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    public Long getId() { return id; }
}