package com.BoredParents.BoredParents.Entities;

import jakarta.persistence.*;
import java.util.List;

@Entity
public class Repositorio {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String nombre;

    private String fechaCreacion;

    @OneToMany(mappedBy = "repositorio", cascade = CascadeType.ALL)
    private List<Usuario> usuarios;

    @OneToMany(mappedBy = "repositorio", cascade = CascadeType.ALL)
    private List<ConsejoRepositorio> consejoRepositorios;

    @OneToMany(mappedBy = "repositorio", cascade = CascadeType.ALL)
    private List<Actividad> actividades;

    // Constructor vacío
    public Repositorio() {
    }

    // Getters y setters para todos los campos
    public long getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(String fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public List<Usuario> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(List<Usuario> usuarios) {
        this.usuarios = usuarios;
    }

    public List<ConsejoRepositorio> getConsejoRepositorios() {
        return consejoRepositorios;
    }

    public void setConsejoRepositorios(List<ConsejoRepositorio> consejoRepositorios) {
        this.consejoRepositorios = consejoRepositorios;
    }

    public List<Actividad> getActividades() {
        return actividades;
    }

    public void setActividades(List<Actividad> actividades) {
        this.actividades = actividades;
    }
}
