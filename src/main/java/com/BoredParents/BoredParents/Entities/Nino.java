package com.BoredParents.BoredParents.Entities;

import jakarta.persistence.*;
import java.util.List;

@Entity
public class Nino {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String nombre;

    private String fechaNacimiento;

    private String avatar;

    private String intereses;

    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;

    @OneToOne(mappedBy = "niño", cascade = CascadeType.ALL)
    private LibroVida libroVida;

    @OneToMany(mappedBy = "niño", cascade = CascadeType.ALL)
    private List<NinoRepositorio> ninoRepositorios;

    // Constructor vacío
    public Nino() {
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

    public String getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getIntereses() {
        return intereses;
    }

    public void setIntereses(String intereses) {
        this.intereses = intereses;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public LibroVida getLibroVida() {
        return libroVida;
    }

    public void setLibroVida(LibroVida libroVida) {
        this.libroVida = libroVida;
    }

    public List<NinoRepositorio> getNinoRepositorios() {
        return ninoRepositorios;
    }

    public void setNiñoRepositorios(List<NinoRepositorio> ninoRepositorios) {
        this.ninoRepositorios = ninoRepositorios;
    }
}
