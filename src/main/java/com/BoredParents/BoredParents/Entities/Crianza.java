package com.BoredParents.BoredParents.Entities;

import org.springframework.data.repository.support.Repositories;

import jakarta.persistence.*;
import lombok.Setter;


@Entity
public class Crianza {
    // Getters y setters para todos los campos
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Setter
    private String nombre;

    @Setter
    private String categoria;


    @ManyToOne
    @JoinColumn(name = "repositorio_id")
    private Repositories repositorio;

    // Constructor vacío
    public Crianza() {
    }

    public void setId(int id) {
        this.id = id;
    }

}
