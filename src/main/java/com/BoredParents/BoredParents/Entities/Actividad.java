package com.BoredParents.BoredParents.Entities;
<<<<<<< HEAD
=======
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
>>>>>>> 91a23a9753bed70d84ccf03050a6417ff21f5ece

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
<<<<<<< HEAD


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
=======
import jakarta.persistence.ManyToOne;
import jakarta.persistence.JoinColumn;
>>>>>>> 91a23a9753bed70d84ccf03050a6417ff21f5ece

@Entity
public class Actividad {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
<<<<<<< HEAD
    private int id;
    private String nombre;
    private String descripcion;
    private String categoria;
=======
    private Long id_actividad;
    private String nombre;
    private String descripcion;

    @ManyToOne
    @JoinColumn(name = "id_evento")
    @JsonIgnoreProperties("actividades")
    private eventos evento;
>>>>>>> 91a23a9753bed70d84ccf03050a6417ff21f5ece

    public Actividad() {
    }

<<<<<<< HEAD
    public Actividad(int id, String nombre, String descripcion, String categoria) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.categoria = categoria;
    }

    public int getId() {
        return id;
=======
    public Long getId_actividad() {
        return id_actividad;
>>>>>>> 91a23a9753bed70d84ccf03050a6417ff21f5ece
    }

    public String getNombre() {
        return nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

<<<<<<< HEAD
    public String getCategoria() {
        return categoria;
    }

    public void setId(int id) {
        this.id = id;
=======
    public eventos getEvento() {
        return evento;
    }

    public void setId_actividad(Long id_actividad) {
        this.id_actividad = id_actividad;
>>>>>>> 91a23a9753bed70d84ccf03050a6417ff21f5ece
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

<<<<<<< HEAD
    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    @Override
    public String toString() {
        return "Actividad{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", descripcion='" + descripcion + '\'' +
                ", categoria='" + categoria + '\'' +
                '}';
    }
=======
    public void setEvento(eventos evento) {
        this.evento = evento;
    }
    @Override
public String toString() {
    return "Actividad{" +
            "id_actividad=" + id_actividad +
            ", nombre='" + nombre + '\'' +
            ", descripcion='" + descripcion + '\'' +
            '}';
}

>>>>>>> 91a23a9753bed70d84ccf03050a6417ff21f5ece
}
