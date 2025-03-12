package com.pro.models;

import jakarta.persistence.*;

@Entity
@Table(name = "roles") // Especifica el nombre de la tabla en la base de datos
public class Rol {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Generación automática del ID
    private Long id;

    @Column(name = "nombre", nullable = false, unique = true) // Configuración de la columna
    private String nombre;

    // Constructor vacío (requerido por JPA)
    public Rol() {
    }

    // Constructor con parámetros
    public Rol(String nombre) {
        this.nombre = nombre;
    }

    // Getters y Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    // Método toString (opcional, para depuración)
    @Override
    public String toString() {
        return "Rol{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                '}';
    }
}