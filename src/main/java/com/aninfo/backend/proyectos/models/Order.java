package com.aninfo.backend.proyectos.models;

import javax.persistence.*;

@Entity
@Table(name = "order")
public class Order {
    @Id
    private Long projectId;

    @Id
    private Long clientId;
}