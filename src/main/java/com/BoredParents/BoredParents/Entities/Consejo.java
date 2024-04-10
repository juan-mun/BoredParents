package com.BoredParents.BoredParents.Entities;

import jakarta.persistence.*;
import java.util.List;

@Entity
public class Consejo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String titulo;

    private String descripcion;

    private String categoria;

    @OneToMany(mappedBy = "consejo", cascade = CascadeType.ALL)
    private List<UsuarioConsejo> usuarioConsejos;

    @OneToMany(mappedBy = "consejo", cascade = CascadeType.ALL)
    private List<ConsejoRepositorio> consejoRepositorios;

    // Constructor vacío
    public Consejo() {
    }

    // Getters y setters para todos los campos
    public long getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public List<UsuarioConsejo> getUsuarioConsejos() {
        return usuarioConsejos;
    }

    public void setUsuarioConsejos(List<UsuarioConsejo> usuarioConsejos) {
        this.usuarioConsejos = usuarioConsejos;
    }

    public List<ConsejoRepositorio> getConsejoRepositorios() {
        return consejoRepositorios;
    }

    public void setConsejoRepositorios(List<ConsejoRepositorio> consejoRepositorios) {
        this.consejoRepositorios = consejoRepositorios;
    }
}
