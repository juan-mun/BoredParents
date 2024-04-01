package com.BoredParents.BoredParents.Entities;

import jakarta.persistence.*;
import java.util.List;

@Entity
public class Usuarios {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int ID_Tutor;
    private String nombre;
    private String apellido;
    private String email;
    private String contraseña;
    private int fecha_nacimiento;
    private int direccion;

    @OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL)
    private List<Infantes> infantes;

    @OneToOne(mappedBy = "usuario", cascade = CascadeType.ALL)
    private Login login;

    // Constructor vacío
    public Usuarios() {
    }

    // Getters y setters para todos los campos
    public int getID_Tutor() {
        return ID_Tutor;
    }

    public void setID_Tutor(int ID_Tutor) {
        this.ID_Tutor = ID_Tutor;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public int getFecha_nacimiento() {
        return fecha_nacimiento;
    }

    public void setFecha_nacimiento(int fecha_nacimiento) {
        this.fecha_nacimiento = fecha_nacimiento;
    }

    public int getDireccion() {
        return direccion;
    }

    public void setDireccion(int direccion) {
        this.direccion = direccion;
    }

    // Getter y setter para la lista de infantes
    public List<Infantes> getInfantes() {
        return infantes;
    }

    public void setInfantes(List<Infantes> infantes) {
        this.infantes = infantes;
    }

    // Getter y setter para login
    public Login getLogin() {
        return login;
    }

    public void setLogin(Login login) {
        this.login = login;
    }
}