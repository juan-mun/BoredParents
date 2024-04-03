package com.BoredParents.BoredParents.Entities;

import jakarta.persistence.*;

import java.time.LocalDate;


@Entity
public class Infantes {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_infante;
    private String nombre;
    private String apellido;
    private LocalDate fecha_nacimiento;

    @ManyToOne
    @JoinColumn(name = "ID_Tutor")
    private Usuarios usuario;

    // Constructor vacío
    public Infantes() {
    }

    // Getters y setters para todos los campos
    public Long getId_infante() {
        return id_infante;
    }

    public void setId_infante(Long id_infante) {
        this.id_infante = id_infante;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public LocalDate getFecha_nacimiento() {
        return fecha_nacimiento;
    }

    public void setFecha_nacimiento(LocalDate fecha_nacimiento) {
        this.fecha_nacimiento = fecha_nacimiento;
    }

    // Getter y setter para el usuario
    public Usuarios getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuarios usuario) {
        this.usuario = usuario;
    }
}