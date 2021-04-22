package com.accenture.pruebatecnica.data.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

/**
 * Clase que representa el modelo de la entidad Producto
 * @author DANIEL
 * @version 1.0 20/04/2021
 *
 */
@Data
@Entity
@Table(name = "PRODUCTO")
public class Producto {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_PRODUCTO")
	private Long idProducto;
	
	@Column(name = "NOMBRE")
	private String nombre;
	
	@Column(name = "VALOR")
	private Float valor;
}
