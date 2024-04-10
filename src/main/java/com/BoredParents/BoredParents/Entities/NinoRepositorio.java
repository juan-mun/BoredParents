package com.BoredParents.BoredParents.Entities;

import jakarta.persistence.*;

@Entity
public class NinoRepositorio {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne
    @JoinColumn(name = "niño_id")
    private Nino niño;

    @ManyToOne
    @JoinColumn(name = "repositorio_id")
    private Repositorio repositorio;

    // Constructor vacío
    public NinoRepositorio() {
    }

    // Getters y setters para todos los campos
    public long getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Nino getNiño() {
        return niño;
    }

    public void setNiño(Nino niño) {
        this.niño = niño;
    }

    public Repositorio getRepositorio() {
        return repositorio;
    }

    public void setRepositorio(Repositorio repositorio) {
        this.repositorio = repositorio;
    }
}
