package com.aninfo.backend.proyectos.models;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "order")
@IdClass(Order.class)
public class Order implements Serializable {
    @Id
    private long projectId;

    @Id
    private long clientId;
}

