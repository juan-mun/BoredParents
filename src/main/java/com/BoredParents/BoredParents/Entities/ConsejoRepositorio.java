package com.BoredParents.BoredParents.Entities;

import jakarta.persistence.*;

@Entity
public class ConsejoRepositorio {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne
    @JoinColumn(name = "consejo_id")
    private Consejo consejo;

    @ManyToOne
    @JoinColumn(name = "repositorio_id")
    private Repositorio repositorio;

    // Constructor vacío
    public ConsejoRepositorio() {
    }

    // Getters y setters para todos los campos
    public long getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Consejo getConsejo() {
        return consejo;
    }

    public void setConsejo(Consejo consejo) {
        this.consejo = consejo;
    }

    public Repositorio getRepositorio() {
        return repositorio;
    }

    public void setRepositorio(Repositorio repositorio) {
        this.repositorio = repositorio;
    }
}
