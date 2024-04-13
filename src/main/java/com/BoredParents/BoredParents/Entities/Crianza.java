package com.BoredParents.BoredParents.Entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
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

    @Setter
    @ManyToOne
    @JoinColumn(name = "repositorio_id")
    private Repositorio repositorio;

    // Constructor vacío
    public Crianza() {
    }

    public void setId(int id) {
        this.id = id;
    }

}
