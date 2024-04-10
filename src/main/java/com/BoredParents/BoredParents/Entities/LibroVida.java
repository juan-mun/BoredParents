package com.BoredParents.BoredParents.Entities;

import jakarta.persistence.*;

@Entity
public class LibroVida {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String material;

    private String descripcion;

    private String titulo;

    @OneToOne
    @JoinColumn(name = "niño_id")
    private Nino nino;

    // Constructor vacío
    public LibroVida() {
    }

    // Getters y setters para todos los campos
    public long getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Nino getNiño() {
        return nino;
    }

    public void setNiño(Nino niño) {
        this.nino = niño;
    }
}
