package com.accenture.pruebatecnica.data.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

/**
 * Clase que representa el modelo de la entidad Usuario
 * @author DANIEL
 * @version 1.0 20/04/2021
 *
 */
@Data
@Entity
@Table(name = "USUARIO")
public class Usuario {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_USUARIO")
	private Long idUsuario;
	
	@Column(name = "CEDULA", unique = true, nullable = false)
	private String cedula;
	
	@Column(name = "NOMBRE")
	private String nombre;
	
	@Column(name = "DIRECCION")
	private String direccion;
	
	@Column(name = "TELEFONO")
	private String telefono;	
	
}
