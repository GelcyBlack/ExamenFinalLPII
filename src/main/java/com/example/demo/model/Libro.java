package com.example.demo.model;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "libro")
public class Libro {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idlibro", nullable = false)
	public Long idlibro;
	
	@Column(name = "Nombre", nullable = false)
	public String Nombre;
	
	@Column(name = "Autor", nullable = false)
	public String Autor;
	
	@Column(name = "fechaDePublicacion", nullable = false)
	public String fechaDePublicacion;
	
	@ManyToOne
	@JoinColumn(name = "idgenero", nullable = false)
	public Genero genero;

}