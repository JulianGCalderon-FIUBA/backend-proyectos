package com.aninfo.backend.proyectos.models;


import javax.persistence.*;

@Entity
@Table(name = "element")
public class MyModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
}