package com.BoredParents.BoredParents.Entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Actividad {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_actividad;
    private String nombre;
    private String Descripcion;
    private String Categoria;
    private String Duracion;
    private String url;

    public Long getId_actividad() {
        return id_actividad;
    }

    public void setId_actividad(Long id_actividad) {
        this.id_actividad = id_actividad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return Descripcion;
    }

    public void setDescripcion(String descripcion) {
        Descripcion = descripcion;
    }

    public String getCategoria() {
        return Categoria;
    }

    public void setCategoria(String categoria) {
        Categoria = categoria;
    }

    public String getDuracion() {
        return Duracion;
    }

    public void setDuracion(String duracion) {
        Duracion = duracion;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    
}