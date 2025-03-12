package com.pro.models;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "eventos")
public class Evento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String titulo;
    private String descripcion;
    private String fecha;
    
    @ManyToMany(mappedBy = "favoritos")
    private List<Usuario> usuariosFavoritos;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
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

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public List<Usuario> getUsuariosFavoritos() {
		return usuariosFavoritos;
	}

	public void setUsuariosFavoritos(List<Usuario> usuariosFavoritos) {
		this.usuariosFavoritos = usuariosFavoritos;
	}

}